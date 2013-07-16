package com.grikly.request;

import javax.ws.rs.core.MultivaluedMap;

public abstract class HttpRequest <E,T> implements IHttpRequest<E, T> {
	
	private final String apiKey;
	private final Class<T> type;
	private final String path;
	private final MultivaluedMap<String, String> queryMap; 
	private final E model;
	private final String authedInfo;
	
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
	 * @return the apiKey
	 */
	public String getApiKey()
	{
		return apiKey;
	}
	

	/**
	 * @return the type
	 */
	public Class<T> getType()
	{
		return type;
	}

	
	/**
	 * @return the path
	 */
	public String getPath()
	{
		return path;
	}

	/**
	 * @return the queryMap
	 */
	public MultivaluedMap<String, String> getQueryMap() 
	{
		return queryMap;
	}


	/**
	 * @return the model
	 */
	public E getModel() 
	{
		return model;
	}
	

	/**
	 * @return the authInfo
	 */
	public String getAuthInfo ()
	{
		return authedInfo;
	}



}//end HttpRequest class
