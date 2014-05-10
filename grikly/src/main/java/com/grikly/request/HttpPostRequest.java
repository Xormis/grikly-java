package com.grikly.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
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
import com.grikly.exception.GriklyException;


/**
 * HttpPostRequest is used to execute a HTTP
 * Request using the HTTP POST method. This class 
 * is thread-safe and cannot be sub-classed.
 * @author Mario Dennis
 *
 * @param <E>
 * @param <T>
 */
public final class HttpPostRequest <E,T> extends AbstractHttpRequest<E, T>{
	
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
	public T execute() throws GriklyException
	{
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost();
		try 
		{
			addModel(post);
			addHttpParams(post);// adds HTTP Parameters to post request
			HttpResponse response = client.execute(prepareRequestMethod(post));
			Header contentType = response.getFirstHeader("Content-Type");
			int statusCode = response.getStatusLine().getStatusCode();
			
			if ((statusCode >= 200 && statusCode < 300) &&(contentType != null && contentType.getValue().contains("application/json")))
			{
				String entity = EntityUtils.toString(response.getEntity());
				return new Gson().fromJson(entity, getClazz());
			}
			else if (statusCode >= 200 && statusCode < 300)
				return null;
			else
				throw new GriklyException(EntityUtils.toString(response.getEntity()));
		} 
		catch (ClientProtocolException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		};
		return null;
	}//end execute method
	
	
	/*
	 * Add model to request
	 * @param post
	 * @throws UnsupportedEncodingException
	 */
	private void addModel (HttpPost post) throws UnsupportedEncodingException
	{
		if (getModel() != null)
		{
			StringEntity entity = new StringEntity(new Gson().toJson(getModel()).toString());
			entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			post.setHeader("Content-type", "application/json");
			post.setEntity(entity);
		}
	}//end addModel method
	

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
