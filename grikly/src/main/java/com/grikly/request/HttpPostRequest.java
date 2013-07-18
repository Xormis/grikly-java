package com.grikly.request;

import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.grikly.JerseyUtil;
import com.grikly.URL;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * HttpPostRequest is used to execute a HTTP
 * Request using the HTTP POST method. This class 
 * is thread-safe and cannot be sub-classed.
 * @author Mario Dennis
 *
 * @param <E>
 * @param <T>
 */
public final class HttpPostRequest <E,T> extends HttpRequest<E, T>{
	
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
	public T execute() 
	{
		Client client = JerseyUtil.getClient();
		if (getPath() == null)
			throw new NullPointerException ("No Path was supplied");
		
		if (getModel() == null)
			throw new NullPointerException ("No Model was supplied");
		
		WebResource resource = client.resource(String.format(URL.BASE.toString(), getPath()));
		Gson gson = new Gson();
		
		ClientResponse response;
		
		//adds authInfo when supplied
		if (getAuthInfo() != null)
			response = resource.header("ApiKey", getApiKey())
							   .header("Authorization","Basic " + getAuthInfo())
							   .type(MediaType.APPLICATION_JSON)
							   .accept(MediaType.APPLICATION_JSON)
							   .post(ClientResponse.class,gson.toJson(getModel()));
		
		else 
			response = resource.header("ApiKey", getApiKey())
							   .type(MediaType.APPLICATION_JSON)
							   .accept(MediaType.APPLICATION_JSON)
							   .post(ClientResponse.class,gson.toJson(getModel()));

		if (response.getStatus() == 200)
		{
			String json = response.getEntity(String.class);
			return gson.fromJson(json, getType());
		}
		if (response.getStatus() == 201)
		{
			String json = response.getEntity(String.class);
			return gson.fromJson(json, getType());
		}
		System.err.println(response.getClientResponseStatus());
		return null;
	}//end execute method

}//end HttpPostRequest class
