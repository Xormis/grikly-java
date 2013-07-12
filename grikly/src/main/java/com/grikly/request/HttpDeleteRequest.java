package com.grikly.request;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.grikly.JerseyUtil;
import com.grikly.URL;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HttpDeleteRequest <E,T> implements IHttpRequest<E, T> {

	private String apiKey;
	private E model;
	private Class<T> type;
	private Object path;
	
	/**
	 * 
	 * @param apiKey
	 * @param model
	 * @param path
	 * @param type
	 */
	public HttpDeleteRequest (String apiKey,E model,Object path,Class<T> type)
	{
		this.apiKey = apiKey;
		this.model = model;
		this.path = path;
		this.type = type;
	}//end constructor 
	
	
	/**
	 * 
	 */
	public T execute(URL url)
	{
		Client client = JerseyUtil.getClient();
		WebResource resource = client.resource(String.format(url.toString(), path));
		Gson gson = new Gson();
		ClientResponse response = resource.header("ApiKey", apiKey)
										  .type(MediaType.APPLICATION_JSON)
										  .delete(ClientResponse.class,gson.toJson(model));
		if (response.getStatus() == 200)
		{
			if (response.getHeaders().get("Content-type").equals("application/json; charset=utf-8"))
			{
				String json = response.getEntity(String.class);
				return gson.fromJson(json, type);
			}
			System.out.println(response.getClientResponseStatus());
		}
		System.out.println(response.getClientResponseStatus());
		return null;
	}//end execute method

}//end HttpDeleteRequest class
