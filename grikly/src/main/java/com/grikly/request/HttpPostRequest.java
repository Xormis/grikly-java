package com.grikly.request;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.grikly.URL;
import com.grikly.exception.ForbiddenException;
import com.grikly.exception.NotFoundException;
import com.grikly.exception.UnauthorizedException;

/**
 * HttpPostRequest is used to execute a HTTP
 * Request using the HTTP POST method. This class 
 * is thread-safe and cannot be sub-classed.
 * @author Mario Dennis
 *
 * @param <E>
 * @param <T>
 */
public final class HttpPostRequest <E,T> extends HttpRequest<E, T>{
	
	/**
	 * HttpPostRequest Default Constructor.
	 * @author Mario Dennis
	 * @param HttpBuilder<E, T>
	 */
	protected HttpPostRequest(HttpBuilder<E, T> builder)
	{
		super(builder);
	}//end constructor
	
	
	/**
	 * Execute HTTP POST request to Grikly Server.
	 * @author Mario Dennis
	 * @return T
	 */
	public T execute()
	{
		
		if (getPath() == null)
			throw new NullPointerException ("No Path was supplied");
		
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(String.format(URL.BASE.toString(), getPath()));
		
		post.addHeader("ApiKey",getApiKey());
		
		if (getAuthInfo() != null)
			post.addHeader("Authorization","Basic " + getAuthInfo());
		try 
		{
			Gson gson = new Gson ();
			
			if (getModel() != null)
			{
				StringEntity entity = new StringEntity(gson.toJson(getModel()).toString());
				entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
				post.setHeader("Content-type", "application/json");
				post.setEntity(entity);
			}
			
			HttpResponse response = client.execute(post);
			if(response.getStatusLine().getStatusCode() == 200)
			{
				String result = EntityUtils.toString(response.getEntity());
				if (result != null)
					return new GsonBuilder().setDateFormat("yyyy-mm-dd'T'HH:mm:ss").create().fromJson(result, getType());
			}
			
			if (response.getStatusLine().getStatusCode() == 201)
			{
				String result = EntityUtils.toString(response.getEntity());
				if (result != null)
					return gson.fromJson(result, getType());
			}
			if (response.getStatusLine().getStatusCode() == 401)
				throw new UnauthorizedException("Http: 401 " + EntityUtils.toString(response.getEntity()));
			
			if (response.getStatusLine().getStatusCode() == 404)
				throw new NotFoundException("Http 404:" + EntityUtils.toString(response.getEntity()));
			
			if (response.getStatusLine().getStatusCode() == 403)
				throw new ForbiddenException("Http 403: " + EntityUtils.toString(response.getEntity()));
		} 
		catch (ClientProtocolException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}//end execute method

}//end HttpPostRequest class
