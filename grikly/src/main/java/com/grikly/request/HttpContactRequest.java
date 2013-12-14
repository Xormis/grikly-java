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
		try 
		{
			HttpResponse response = client.execute(prepareRequestMethod(new HttpGet()));
			if (response.getStatusLine().getStatusCode() == 200)
			{
				String entity = EntityUtils.toString(response.getEntity());
				ArrayList<Connection>arrayList = new Gson().fromJson(entity,new TypeToken<ArrayList<Connection>>(){}.getType());
				return arrayList;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}//end execute method	

	
}//end HttpContactRequest class
