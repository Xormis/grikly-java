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
		HttpClient client = new DefaultHttpClient ();
		HttpPut put = new HttpPut();
		Gson gson = new Gson();
		String result = null;
		try 
		{
			if (getModel() != null)
			{
				StringEntity entity = new StringEntity(gson.toJson(getModel()).toString());
				entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
				put.setHeader("Content-type", "application/json");
				put.setEntity(entity);
			}
			
			HttpResponse response = client.execute(prepareRequestMethod(put));
			result = EntityUtils.toString(response.getEntity());			
		}
		catch (UnsupportedEncodingException e){
			e.printStackTrace();
		} 
		catch (ClientProtocolException e){
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return (result != null) ? gson.fromJson(result,getClazz()) : null;
	}//end execute method

}//end HttpPutRequest class
