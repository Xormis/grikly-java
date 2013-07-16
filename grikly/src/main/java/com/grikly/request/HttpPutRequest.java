package com.grikly.request;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.grikly.JerseyUtil;
import com.grikly.URL;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * HttpPutRequest is used to execute a HTTP
 * Request using the HTTP PUT method. This class 
 * is thread-safe and cannot be sub-classed.
 * @author Mario Dennis
 *
 * @param <E>
 * @param <T>
 */
public final class HttpPutRequest <E,T> extends HttpRequest<E, T> {

	/**
	 * HttpPutRequest Default Constructor.
	 * @author Mario Dennis
	 * @param HttpBuilder<E, T>
	 */
	protected HttpPutRequest (HttpBuilder<E, T> builder)
	{
		super(builder);
	}//end constructor
	
	
	/**
	 * Execute HTTP PUT request to Grikly Server.
	 * @author Mario Dennis
	 * @return T
	 */
	public T execute()
	{
		
		if (getPath() == null)
			throw new NullPointerException ("No Path was supplied");
		
		if (getModel () == null)
			throw new NullPointerException("No Model was Supplied");
		
		Client client = JerseyUtil.getClient();
		WebResource resource = client.resource(String.format(URL.BASE.toString(), getPath()));
		Gson gson = new Gson();
		ClientResponse response;
		
		//adds authInfo when supplied
		if (getAuthInfo() != null)
			response = resource.header("ApiKey", getApiKey())
							   .header("Authorization","Basic " + getAuthInfo())
			   				   .type(MediaType.APPLICATION_JSON)
			   				   .accept(MediaType.APPLICATION_JSON)
			   				   .put(ClientResponse.class,gson.toJson(getModel()));
			
		else
			response = resource.header("ApiKey", getApiKey())
							   .type(MediaType.APPLICATION_JSON)
							   .accept(MediaType.APPLICATION_JSON)
							   .put(ClientResponse.class,gson.toJson(getModel()));
		
		if (response.getStatus() == 200)
		{
			String json = response.getEntity(String.class);
			return gson.fromJson(json, getType());
		}
		System.out.println(response.getClientResponseStatus());
		return null;
	}//end execute method

}//end HttpPutRequest class
