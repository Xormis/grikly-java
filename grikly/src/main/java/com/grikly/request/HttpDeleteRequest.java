package com.grikly.request;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.grikly.URL;
import com.grikly.exception.ForbiddenException;
import com.grikly.exception.InternalServerErrorException;
import com.grikly.exception.NotFoundException;

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
				return  "Success";
						
			if (response.getStatusLine().getStatusCode() == 404)
				throw new NotFoundException(EntityUtils.toString(response.getEntity()));
			
			if (response.getStatusLine().getStatusCode() == 403)
				throw new ForbiddenException(EntityUtils.toString(response.getEntity()));
			
			if (response.getStatusLine().getStatusCode() == 500)
				throw new InternalServerErrorException(EntityUtils.toString(response.getEntity()));
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
		return  "Fail";
	}//end execute method

}//end HttpDeleteRequest class
