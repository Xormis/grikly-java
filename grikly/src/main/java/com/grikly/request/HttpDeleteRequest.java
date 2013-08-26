package com.grikly.request;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.grikly.URL;

/**
 * HttpDeleteRequest is used to execute a HTTP
 * Request using the HTTP DELETE method. This class 
 * is thread-safe and cannot be sub-classed.
 * @author Mario Dennis
 *
 * @param <E>
 * @param <T>
 */
public final class HttpDeleteRequest <E,T> extends HttpRequest<E, T> {


	/**
	 * HttpDeleteRequest Default Constructor.
	 * @author Mario Dennis
	 * @param HttpBuilder<E, T>
	 */
	protected HttpDeleteRequest (HttpBuilder<E, T> builder)
	{
		super(builder);
	}//end constructor 
	
	
	/**
	 * Executes HTTP DELETE Request to Grikly Server.
	 * @author Mario Dennis
	 * @return T
	 */
	public T execute()
	{
		if (getPath() == null)
			throw new NullPointerException ("No Path was supplied");
		
		HttpClient client = new DefaultHttpClient ();
		HttpDelete delete = new HttpDelete(String.format(URL.BASE.toString(), getPath()));
		
		delete.addHeader("ApiKey",getApiKey());
		if (getAuthInfo() != null)
			delete.addHeader("Authorization","Basic " + getAuthInfo());
		
		try 
		{
			HttpResponse response = client.execute(delete);
			if (response.getStatusLine().getStatusCode() == 200)
			{
				
				if (response.containsHeader("Content-type: application/json; charset=utf-8"))
				{
					String result = EntityUtils.toString(response.getEntity());
					if (result != null)
						return new Gson().fromJson(result, getType());
				}
				System.out.println(response.getStatusLine().getStatusCode());
			}
		} 
		catch (ClientProtocolException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}//end execute method

}//end HttpDeleteRequest class
