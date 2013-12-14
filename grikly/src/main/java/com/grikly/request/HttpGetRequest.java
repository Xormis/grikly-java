package com.grikly.request;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;


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
		String entity = null;
		try 
		{
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(prepareRequestMethod(new HttpGet()));
		
			entity = EntityUtils.toString(response.getEntity());	
		} 
		catch (ClientProtocolException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return (entity != null) ? new Gson().fromJson(entity, getType()) : null;
	}//end execute method


}//end HttpGetRequest method
