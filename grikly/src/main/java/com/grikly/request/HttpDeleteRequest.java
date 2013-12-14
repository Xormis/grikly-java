package com.grikly.request;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;


/**
 * HttpDeleteRequest is used to execute a HTTP
 * Request using the HTTP DELETE method. This class 
 * is thread-safe and cannot be sub-classed.
 * @author Mario Dennis
 *
 * @param <E>
 * @param <T>
 */
public final class HttpDeleteRequest <E,T> extends HttpRequest<E, String> {


	/**
	 * HttpDeleteRequest Default Constructor.
	 * @author Mario Dennis
	 * @param HttpBuilder<E, T>
	 */
	protected HttpDeleteRequest (HttpBuilder<E, String> builder)
	{
		super(builder);
	}//end constructor 
	
	
	/**
	 * Executes HTTP DELETE Request to Grikly Server.
	 * @author Mario Dennis
	 * @return T
	 */
	public String execute()
	{
		HttpClient client = new DefaultHttpClient ();
		HttpResponse response = null;
		try 
		{
			response = client.execute(prepareRequestMethod(new HttpPut()));
		} 
		catch (ClientProtocolException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return (response.getStatusLine().getStatusCode() == 200) ? "success" : "fail";
	}//end execute method

}//end HttpDeleteRequest class
