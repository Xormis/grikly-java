package com.grikly.request;

import java.util.ArrayList;
import java.util.Map;

import com.grikly.model.AccessToken;
import com.grikly.model.Connection;


/**
 * HttpBuilder class is used to set properties
 * of HttpRequest and to build instances of HttpRequest
 * base classes. This is require to ensure HttpRequest
 * base classes are  immutable and thread-safe.
 * @author Mario Dennis
 *
 * @param <E> element type for processing
 * @param <T> return type.
 */
public final class HttpBuilder<E,T> {
	
	private String path;
	private String authInfo;
	private E model;
	private String apiKey;
	private Class<T> type;
	private Map<String, String> params;
	private AccessToken accessToken;
	
	
	/**
	 * HttpBuilder Default constructor.
	 * @author Mario Dennis
	 * @param type that will be returned by IHttpRequest
	 * @param apiKey
	 */
	public HttpBuilder (Class<T> type,String apiKey)
	{
		this.type = type;
		this.apiKey = apiKey;
	}//end constructor

	
	
	/**
	 * Builds HttpGetRequest object.
	 * @author Mario Dennis
	 * @return HttpGetRequest<E,T>
	 */
	public Request<E, T> buildHttpGet ()
	{
		return new HttpGetRequest<E,T>(this);
	}//end buildHttpGet method
	
	
	/**
	 * Builds HttpPostRequest object.
	 * @author Mario Dennis
	 * @return HttpPostRequest<E,T>
	 */
	public Request<E, T> buildHttpPost ()
	{
		return new HttpPostRequest<E, T>(this);
	}//end  buildHttpPost method 
	
	
	
	/**
	 * Builds HttpDeleteRequest object.
	 * @author Mario Dennis
	 * @return HttpDeleteRequest<E,T>
	 */
	@SuppressWarnings("unchecked")
	public HttpDeleteRequest<E,String> buildHttpDelete ()
	{
		return new HttpDeleteRequest<E,String>((HttpBuilder<E, String>) this);
	}//end buildHttpDelete method
	
	
	
	/**
	 * Builds HttpPutRequest object.
	 * @author Mario Dennis
	 * @return HttpPutRequest<E,T>
	 */
	public Request<E, T> buildHttpPut ()
	{
		return new HttpPutRequest<E, T>(this);
	}//end buildHttpPut method
	
	
	/**
	 * Builds a HttpMultiPartRequest
	 * @param model
	 * @return
	 */
	public Request<E, T> buildHttpMultiPartRequest (E model)
	{
		this.model = model;
		return new HttpMultiPartRequest <E,T>(this);
	}//end 
	
	
	/**
	 * Build HttpContactRequest object
	 * @param searchQuery
	 * @param page
	 * @return
	 */
	public Request <String, ArrayList<Connection>> buildHttpContactRequest ()
	{
		HttpBuilder<String, ArrayList<Connection>> builder = new HttpBuilder<String, ArrayList<Connection>>(null, getApiKey());
		
		if (this.getAuthInfo() != null)
			builder.setAuthInfo(this.getAuthInfo().getBytes());
		
		if (this.getPath() != null)
			builder.setPath(this.getPath());
		
		return new HttpContactRequest(builder);
	}//end buildContactRequest method
	
	
	/**
	 * Set authInfo attribute.
	 * @author Mario Dennis
	 * @param authInfo 
	 * @return HttpBuilder <E,T>
	 */
	public HttpBuilder<E, T> setAuthInfo (byte[] authInfo)
	{
		if (authInfo != null)
			this.authInfo = new String(authInfo);
		return this;
	}//end setAuthInfo method
	
	
	/**
	 * Set UserCredential
	 * @author mario
	 * @param userCredential
	 */
	public void setAccessToken (AccessToken accessToken)
	{
		this.accessToken = accessToken;
	}//end setAccessToken method
	
	
	
	/**
	 * Set model attribute. This attribute 
	 * is data being sent with request
	 * @author Mario Dennis
	 * @param model
	 * @return HttpBuilder <E,T>
	 */
	public HttpBuilder<E,T> setModel (E model)
	{
		this.model = model;
		return this;
	}//end setModel method
	
	
	public HttpBuilder<E, T> addHttpParams (Map<String, String> params)
	{
		this.params = params;
		return this;
	}//end setHeaderMap method
	
	
	/**
	 * Set path attribute.[Note] path
	 * must be relative to base URL.
	 * @author Mario Dennis
	 * @param path
	 * @return HttpBuilder <E,T>
	 */
	public HttpBuilder<E,T> setPath (String path)
	{
		this.path = String.format(path);
		return this;
	}//end setPath method
	
	
	
	/**
	 * Get ApiKey
	 * @author Mario Dennis
	 * @return String
	 */
	protected String getApiKey()
	{
		return apiKey;
	}//end getApiKey method
	
	
	/**
	 * Get Type
	 * @author Mario Dennis
	 * @return Class <T>
	 */
	protected Class<T> getType ()
	{
		return type;
	}//end getType method
	
	

	/**
	 * Get Model
	 * @author Mario Dennis
	 * @return E
	 */
	protected E getModel ()
	{
		return model;
	}//end getModel method
	

	/**
	 * Get path
	 * @author Mario Dennis
	 * @return String
	 */
	protected String getPath ()
	{
		return path;
	}//end getPath method
	
	
	/**
	 * Get UserCredential 
	 * @return
	 */
	protected AccessToken getAccessToken() 
	{
		return accessToken;
	}//end getAccessToken method
	
	
	/**
	 * Get authInfo
	 * @author Mario Dennis
	 * @return 
	 */
	protected String getAuthInfo ()
	{
		return authInfo;
	}///end getAuthInfo method
	
	
	protected Map<String, String> getHttpParams ()
	{
		return params;
	}
}//end GriklyBuilder class
