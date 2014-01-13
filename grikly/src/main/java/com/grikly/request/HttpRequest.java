package com.grikly.request;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Map;

import org.apache.http.client.methods.HttpRequestBase;

import com.grikly.URL;
import com.grikly.model.AccessToken;

/**
 * HttpRequest is a abstract class that contain
 * all properties that are need to do HTTP Request 
 * @author mario
 *
 * @param <E>
 * @param <T>
 */
public abstract class HttpRequest <E,T> implements Request<E, T> {
	
	private final String apiKey;
	private final Class<T> clazz;
	private final String path;
	private final E model;
	private final String authedInfo;
	private final Map<String, String> paramMap;
	private final AccessToken accessToken;
	
	/**
	 * HttpRequest Default Constructor
	 * @author Mario Dennis
	 * @param HttpBuilder<E,T>
	 */
	protected HttpRequest (HttpBuilder<E, T> builder)
	{
		this.apiKey = builder.getApiKey();
		this.clazz = builder.getType();
		this.path = builder.getPath();
		this.model = builder.getModel();
		this.authedInfo = builder.getAuthInfo();
		this.paramMap = builder.getHttpParams();
		this.accessToken = builder.getAccessToken();
	}//end constructor 
	

	/**
	 * Executes HTTP Request. All base classes
	 * must provide there own implementation
	 * of this method.
	 */
	public abstract T execute();
	
	
	/**
	 * Prepares  HTTP Request by adding the
	 * required headers and correct URLs. [NOTE] This 
	 * method accepts Base Classes of the Apache Http 
	 * Client HttpRequestBase which are HttpGet,HttpPost,
	 * HttpDelete,and HttpPut.
	 * @exception NullPointerException 
	 * @author mario
	 * @return HttpRequestBase
	 * @throws UnsupportedEncodingException 
	 */
	protected HttpRequestBase prepareRequestMethod (HttpRequestBase httpRequestMethod) throws UnsupportedEncodingException
	{
		if (getPath() == null)
			throw new NullPointerException ("No Path was supplied");
		
		httpRequestMethod.setURI(URI.create(String.format(URL.BASE.toString(),getPath())));
		httpRequestMethod.addHeader("ApiKey", getApiKey());
		
		if (accessToken != null)
			httpRequestMethod.addHeader("Authorization", String.format("Bearer %s", accessToken.getAccess_token()));
		
		return httpRequestMethod;
	}//end prepareRequestMethod method
	

	

	
	/**
	 * Get apiKey
	 * @author Mario Dennis
	 * @return the apiKey
	 */
	public String getApiKey()
	{
		return apiKey;
	}//end getApiKey method
	
	
	/**
	 * Get HeaderMap 
	 * @return Map <String,String>
	 */
	public Map<String, String> getHttpParams() 
	{
		return paramMap;
	}


	/**
	 * Get type
	 * @author Mario Dennis
	 * @return the type
	 */
	public Class<T> getClazz()
	{
		return clazz;
	}//end getType method

	
	
	/**
	 * Get path
	 * @author Mario Dennis
	 * @return the path
	 */
	public String getPath()
	{
		return path;
	}//end getPath method
	


	/**
	 * Get model
	 * @author Mario Dennis
	 * @return the model
	 */
	public E getModel() 
	{
		return model;
	}//end getModel method
	

	
	/**
	 * Get authInfo
	 * @author Mario Dennis
	 * @return the authInfo
	 */
	public String getAuthInfo ()
	{
		return authedInfo;
	}//end getAuthInfo method

}//end HttpRequest class
