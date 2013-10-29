package com.grikly.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import com.grikly.model.Contact;

/**
 * HttpContactRequest is used to execute a HTTP
 * Request to fetch Contacts.
 * @author Mario Dennis
 *
 * @param <String>
 * @param ArrayList<Card>
 */
public final class HttpContactRequest extends HttpRequest<String, ArrayList<Contact>> {
	
	/**
	 * HttpContactRequest Default Constructor.
	 * @author Mario Dennis
	 * @param HttpBuilder<E, T>
	 */
	protected HttpContactRequest (HttpBuilder<String,ArrayList<Contact>> builder)
	{
		super(builder);
	}//end constructor
	
	
	/**
	 * Executes HTTP Get Request to Grikly Server.
	 * @author Mario Dennis
	 * @return ArrayList<Card>
	 */
	public ArrayList<Contact> execute() 
	{		
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(String.format(URL.BASE.toString(), "Contacts"));
		get.addHeader("ApiKey", getApiKey());
		
		if (getAuthInfo() != null)
			get.addHeader("Authorization","Basic " + getAuthInfo());
		
		try 
		{
			HttpResponse response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == 200)
			{
				String entity = EntityUtils.toString(response.getEntity());
				ArrayList<Contact>arrayList = new Gson().fromJson(entity,new TypeToken<ArrayList<Contact>>(){}.getType());
				return arrayList;
			}
			if (response.getStatusLine().getStatusCode() == 404)
				throw new NotFoundException("Http 404:" + EntityUtils.toString(response.getEntity()));
			
			if (response.getStatusLine().getStatusCode() == 500)
				throw new ForbiddenException("Http 400: " + EntityUtils.toString(response.getEntity()));
			
			if (response.getStatusLine().getStatusCode() == 500)
				throw new InternalServerErrorException("Http 400: " + EntityUtils.toString(response.getEntity()));
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}//end execute method	
	
	
	/*
	 * construct URL needed for request
	 */
	private String buildUrl (String searchText,int page)
	{
		try {
			searchText = URLEncoder.encode(searchText,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		 StringBuffer buffer = new StringBuffer(String.format(URL.BASE.toString(), "Contacts"));
         buffer.append(String.format("?searchText=%s&page=%d", searchText,page));
         
        // return buffer.toString();
         return String.format(URL.BASE.toString(), "Contacts");
	}//end buildUrl method
	
}//end HttpContactRequest class
