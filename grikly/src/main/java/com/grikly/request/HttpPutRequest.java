package com.grikly.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.grikly.URL;
import com.grikly.exception.ForbiddenException;
import com.grikly.exception.NotFoundException;

/**
 * HttpPutRequest is used to execute a HTTP
 * Request using the HTTP PUT method. This class 
 * is thread-safe and cannot be sub-classed.
 * @author Mario Dennis
 *
 * @param <E>
 * @param <T>
 */
public final class HttpPutRequest <E,T> extends HttpRequest<E, T> {

	/**
	 * HttpPutRequest Default Constructor.
	 * @author Mario Dennis
	 * @param HttpBuilder<E, T>
	 */
	protected HttpPutRequest (HttpBuilder<E, T> builder)
	{
		super(builder);
	}//end constructor
	
	
	/**
	 * Execute HTTP PUT request to Grikly Server.
	 * @author Mario Dennis
	 * @return T
	 */
	public T execute()
	{
		
		if (getPath() == null)
			throw new NullPointerException ("No Path was supplied");
		
		if (getModel () == null)
			throw new NullPointerException("No Model was Supplied");
		
		HttpClient client = new DefaultHttpClient ();
		HttpPut put = new HttpPut(String.format(URL.BASE.toString(), getPath()));
		
		put.addHeader("ApiKey", getApiKey());
		if (getAuthInfo() != null)
			put.addHeader("Authorization","Basic " + getAuthInfo());
		
		Gson gson = new Gson();
		
		try 
		{
			StringEntity entity = new StringEntity(gson.toJson(getModel()).toString());
			entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			put.setHeader("Content-type", "application/json");
			put.setEntity(entity);
			
			HttpResponse response = client.execute(put);
			if (response.getStatusLine().getStatusCode() == 200)
			{
				String json = EntityUtils.toString(entity);
				if (json != null)
					return new Gson().fromJson(json, getType());
			}
			
			if (response.getStatusLine().getStatusCode() == 404)
				throw new NotFoundException("Http 404:" + EntityUtils.toString(response.getEntity()));
			
			if (response.getStatusLine().getStatusCode() == 403)
				throw new ForbiddenException("Http 403: " + EntityUtils.toString(response.getEntity()));
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
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

}//end HttpPutRequest class
