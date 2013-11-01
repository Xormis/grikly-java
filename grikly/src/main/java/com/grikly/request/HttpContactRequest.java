package com.grikly.request;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.grikly.URL;
import com.grikly.exception.ForbiddenException;
import com.grikly.exception.InternalServerErrorException;
import com.grikly.exception.NotFoundException;
import com.grikly.model.Connection;

/**
 * HttpContactRequest is used to execute a HTTP
 * Request to fetch Contacts.
 * @author Mario Dennis
 *
 * @param <String>
 * @param ArrayList<Card>
 */
public final class HttpContactRequest extends HttpRequest<String, ArrayList<Connection>> {
	
	/**
	 * HttpContactRequest Default Constructor.
	 * @author Mario Dennis
	 * @param HttpBuilder<E, T>
	 */
	protected HttpContactRequest (HttpBuilder<String,ArrayList<Connection>> builder)
	{
		super(builder);
	}//end constructor
	
	
	/**
	 * Executes HTTP Get Request to Grikly Server.
	 * @author Mario Dennis
	 * @return ArrayList<Card>
	 */
	public ArrayList<Connection> execute() 
	{		
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(String.format(URL.BASE.toString(), "Contacts/All"));
		get.addHeader("ApiKey", getApiKey());
		
		if (getAuthInfo() != null)
			get.addHeader("Authorization","Basic " + getAuthInfo());
		
		try 
		{
			HttpResponse response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == 200)
			{
				String entity = EntityUtils.toString(response.getEntity());
				ArrayList<Connection>arrayList = new Gson().fromJson(entity,new TypeToken<ArrayList<Connection>>(){}.getType());
				return arrayList;
			}
			if (response.getStatusLine().getStatusCode() == 404)
				throw new NotFoundException(EntityUtils.toString(response.getEntity()));
			
			if (response.getStatusLine().getStatusCode() == 403)
				throw new ForbiddenException(EntityUtils.toString(response.getEntity()));
			
			if (response.getStatusLine().getStatusCode() == 500)
				throw new InternalServerErrorException(EntityUtils.toString(response.getEntity()));
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}//end execute method	

	
}//end HttpContactRequest class
