package com.grikly.request;

import javax.ws.rs.core.MultivaluedMap;

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
	private final MultivaluedMap<String, String> queryMap; 
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
		this.queryMap = builder.getMap();
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
	 * Get queryMap
	 * @author Mario Dennis
	 * @return the queryMap
	 */
	public MultivaluedMap<String, String> getQueryMap() 
	{
		return queryMap;
	}//end getQueryMap method


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
