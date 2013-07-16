package com.grikly.request;

import javax.ws.rs.core.MultivaluedMap;

public class HttpBuilder<E,T> {
	
	private String path;
	private String authInfo;
	private E model;
	private String apiKey;
	private Class<T> type;
	private MultivaluedMap<String, String> queryMap;  
	
	public HttpBuilder (Class<T> type,String apiKey)
	{
		this.type = type;
		this.apiKey = apiKey;
	}

	
	
	public IHttpRequest<E, T> buildHttpGet ()
	{
		return new HttpGetRequest<E,T>(this);
	}
	
	
	public IHttpRequest<E, T> buildHttpPost ()
	{
		return new HttpPostRequest<E, T>(this);
	}
	
	public IHttpRequest<E, T> buildHttpDelete ()
	{
		return new HttpDeleteRequest<E, T>(this);
	}
	
	
	public IHttpRequest<E, T> buildHttpPut ()
	{
		return new HttpPutRequest<E, T>(this);
	}
	
	public HttpBuilder<E, T> setAuthInfo (byte[] authInfo)
	{
		this.authInfo = new String(authInfo);
		return this;
	}
	
	
	public HttpBuilder<E,T> setModel (E model)
	{
		this.model = model;
		return this;
	}
	
	public HttpBuilder<E,T> setPath (String path)
	{
		this.path = String.format(path);
		return this;
	}
	

	public HttpBuilder<E, T> addQueryParam (MultivaluedMap<String, String> queryMap)
	{
		this.queryMap = queryMap;
		return this;
	}//end addQueryParam method 
	
	
	protected String getApiKey()
	{
		return apiKey;
	}
	
	protected Class<T> getType ()
	{
		return type;
	}
	

	public E getModel ()
	{
		return model;
	}
	

	protected String getPath ()
	{
		return path;
	}
	
	protected String getAuthInfo ()
	{
		return authInfo;
	}
	
	protected MultivaluedMap<String,String> getMap ()
	{
		return queryMap;
	}
	
}//end GriklyBuilder class
