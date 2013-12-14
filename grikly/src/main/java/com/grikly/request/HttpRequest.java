package com.grikly.request;

import java.net.URI;

import org.apache.http.client.methods.HttpRequestBase;

import com.grikly.URL;

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
	private final Class<T> type;
	private final String path;
	private final E model;
	private final String authedInfo;
	
	/**
	 * HttpRequest Default Constructor
	 * @author Mario Dennis
	 * @param HttpBuilder<E,T>
	 */
	protected HttpRequest (HttpBuilder<E, T> builder)
	{
		this.apiKey = builder.getApiKey();
		this.type = builder.getType();
		this.path = builder.getPath();
		this.model = builder.getModel();
		this.authedInfo = builder.getAuthInfo();
	}//end constructor 
	

	/**
	 * Executes HTTP Request. All base classes
	 * must provide there own implementation
	 * of this method.
	 */
	public abstract T execute();
	
	
	/**
	 * Prepares  HTTP Request by adding the
	 * required headers and correct URLs. [NOTE] 
	 * This method accepts Base Classes of Apache Http 
	 * Client HttpRequestBase which are HttpGet,HttpPost,
	 * HttpDelete,and HttpPut.
	 * @exception NullPointerException 
	 * @author mario
	 * @return HttpRequestBase
	 */
	protected HttpRequestBase prepareRequestMethod (HttpRequestBase httpRequestMethod)
	{
		if (getPath() == null)
			throw new NullPointerException ("No Path was supplied");
		
		httpRequestMethod.setURI(URI.create(String.format(URL.BASE.toString(),getPath())));
		httpRequestMethod.addHeader("ApiKey", getApiKey());
		
		//adds authInfo when supplied
		if (getAuthInfo() != null)
			httpRequestMethod.addHeader("Authorization","Basic " + getAuthInfo());
		
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
	 * Get type
	 * @author Mario Dennis
	 * @return the type
	 */
	public Class<T> getType()
	{
		return type;
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
