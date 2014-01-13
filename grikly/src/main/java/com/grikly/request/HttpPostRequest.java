package com.grikly.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;


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
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost();
		String result = null;
		Gson gson = new Gson ();
		try 
		{
			if (getModel() != null)
			{
				StringEntity entity = new StringEntity(gson.toJson(getModel()).toString());
				entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
				post.setHeader("Content-type", "application/json");
				post.setEntity(entity);
			}
			
			addHttpParams(post);// adds HTTP Parameters to post request
			HttpResponse response = client.execute(prepareRequestMethod(post));
			result = EntityUtils.toString(response.getEntity());
		} 
		catch (ClientProtocolException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		};
		
		return (result != null) ? gson.fromJson(result, getClazz()) : null;
	}//end execute method
	

	/*
	 * Adds HTTP Parameters to request with 
	 * application/x-www-form-urlencoded encoding.
	 * @param post
	 * @throws UnsupportedEncodingException
	 */
	private void addHttpParams (HttpPost post) throws UnsupportedEncodingException
	{
		Map<String, String> params = super.getHttpParams();
		if (params != null && !params.isEmpty())
		{
			List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
			
			//cycles over Map of parameters
			for (Entry<String, String> entry: params.entrySet())
				nameValuePair.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePair);
			post.setEntity(formEntity);
		}
	}//end addHttpParams method
	
}//end HttpPostRequest class
