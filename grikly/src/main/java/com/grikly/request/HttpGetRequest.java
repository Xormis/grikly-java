package com.grikly.request;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.GsonBuilder;
import com.grikly.URL;
import com.grikly.exception.ForbiddenException;
import com.grikly.exception.NotFoundException;

/**
 * HttpGetRequest is used to execute a HTTP
 * Request using the HTTP GET method. This class 
 * is thread-safe and cannot be sub-classed.
 * @author Mario Dennis
 *
 * @param <E>
 * @param <T>
 */
public final class HttpGetRequest <E,T> extends HttpRequest<E, T> {
	

	/**
	 * HttpGetRequest Default Constructor.
	 * @author Mario Dennis
	 * @param HttpBuilder<E, T>
	 */
	protected HttpGetRequest (HttpBuilder<E, T> builder)
	{
		super(builder);
	}//end constructor 
	
	

	/**
	 * Executes HTTP GET Request to Grikly Server.
	 * @author Mario Dennis
	 * @return T
	 */
	public T execute()
	{
		if (getPath() == null)
			throw new NullPointerException ("No Path was supplied");
		
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(String.format(URL.BASE.toString(),getPath()));
		get.addHeader("ApiKey", getApiKey());
		
		//adds authInfo when supplied
		if (getAuthInfo() != null)
			get.addHeader("Authorization","Basic " + getAuthInfo());
		try 
		{
			HttpResponse response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == 200 )
			{
				String entity = EntityUtils.toString(response.getEntity());
				if (entity != null)
					return new GsonBuilder().setDateFormat("yyyy-mm-dd'T'HH:mm:ss").create()
											.fromJson(entity, getType());
			}
			
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


}//end HttpGetRequest method
