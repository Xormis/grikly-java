package com.grikly.request;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.grikly.exception.GriklyException;


/**
 * HttpGetRequest is used to execute a HTTP
 * Request using the HTTP GET method. This class 
 * is thread-safe and cannot be sub-classed.
 * @author Mario Dennis
 *
 * @param <E>
 * @param <T>
 */
public final class HttpGetRequest <E,T> extends AbstractHttpRequest<E, T> {
	
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
	public T execute() throws GriklyException
	{
		try 
		{
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(prepareRequestMethod(new HttpGet()));
			Header contentType = response.getFirstHeader("Content-Type");
			int statusCode = response.getStatusLine().getStatusCode();
			if ((statusCode >= 200 && statusCode < 300) && (contentType != null) && (contentType.getValue().contains("application/json")))
			{
				String entity = EntityUtils.toString(response.getEntity());
				return new Gson().fromJson(entity, getClazz());
			}
			else if (statusCode >= 200 && statusCode < 300)
				return null;
			else 
				throw new GriklyException(EntityUtils.toString(response.getEntity()));
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
