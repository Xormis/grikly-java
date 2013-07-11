package com.grikly.request;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.google.gson.Gson;
import com.grikly.JerseyUtil;
import com.grikly.URL;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;


public class HttpGetRequest <E,T> implements IHttpRequest<E,T>{
	
	private String apiKey;
	private Class<T> type;
	private E path;
	private MultivaluedMap<String, String> queryMap; 
	
	/**
	 * Constructor that accepts developer ApiKey,the
	 * expected return type as a reflection instance, and 
	 * path.
	 * @author Mario Dennis
	 * @param apiKey
	 * @param type Class<T>
	 * @param path
	 */
	public HttpGetRequest (String apiKey,Class<T> type,E path)
	{
		this.apiKey = apiKey;
		this.type = type;
		this.path = path;
	}//end constructor
	

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void addQueryParam (String key,String value)
	{
		
		if (queryMap == null)
		{
			queryMap = new MultivaluedMapImpl();
		}
		queryMap.add(key, value);
	}//end addQueryParam method 
	
	

	/**
	 * Dispatches a HTTP GET Request to Grikly Server.
	 * @author Mario Dennis
	 */
	public T execute(URL url) 
	{
		Client client = JerseyUtil.getClient();
		WebResource resource;
		
		if (path != null)
			resource = client.resource(String.format(url.toString(),path));
		else 
			resource = client.resource(url.toString());
		
		ClientResponse response;
		

		if (queryMap != null)
			response = resource.queryParams(queryMap).header("ApiKey", apiKey).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		else
			response = resource.header("ApiKey", apiKey).accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() == 200)
		{
		//	if (response.getHeaders().get("Content-type").equals("application/json; charset=utf-8"))
			{
				String result = response.getEntity(String.class);
				Gson gson = new Gson();
				return gson.fromJson(result, type);
			}
		}
		return null;
	}//end execute method
	
}//end HttpGetRequest method
