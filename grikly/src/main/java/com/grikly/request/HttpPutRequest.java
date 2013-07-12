package com.grikly.request;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.grikly.JerseyUtil;
import com.grikly.URL;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class HttpPutRequest <E,T> implements IHttpRequest<E, T> {

	private String apiKey;
	private E model;
	private Class<T> type;
	
	public HttpPutRequest (String apiKey,E model,Class<T> type)
	{
		this.apiKey = apiKey;
		this.model = model;
		this.type = type;
	}//end constructor
	
	
	public T execute(URL url)
	{
		Client client = JerseyUtil.getClient();
		WebResource resource = client.resource(url.toString());
		ClientResponse response = resource.header("ApiKey", apiKey)
										  .type(MediaType.APPLICATION_JSON)
										  .put(ClientResponse.class,model);
		if (response.getStatus() == 200)
		{

			if (response.getHeaders().get("Content-type").equals("application/json; charset=utf-8"))
			{
				String json = response.getEntity(String.class);
				return new Gson().fromJson(json, type);
			}
		}
		return null;
	}//end execute method

}//end HttpPutRequest class
