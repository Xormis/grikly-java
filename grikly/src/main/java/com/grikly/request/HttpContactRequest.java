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

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.grikly.URL;
import com.grikly.exception.NotFoundException;
import com.grikly.model.Card;

/**
 * HttpContactRequest is used to execute a HTTP
 * Request to fetch Contacts.
 * @author Mario Dennis
 *
 * @param <String>
 * @param ArrayList<Card>
 */
public final class HttpContactRequest extends HttpRequest<String, ArrayList<Card>> {
	private final String searchQuery;
	private final int page;
	
	/**
	 * HttpContactRequest Default Constructor.
	 * @author Mario Dennis
	 * @param HttpBuilder<E, T>
	 */
	protected HttpContactRequest (String searchQuery, Integer page, HttpBuilder<String,ArrayList<Card>> builder)
	{
		super(builder);
		this.searchQuery = searchQuery;
		this.page = page;
	}//end constructor
	
	
	/**
	 * Executes HTTP Get Request to Grikly Server.
	 * @author Mario Dennis
	 * @return ArrayList<Card>
	 */
	public ArrayList<Card> execute() 
	{		
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(buildUrl(searchQuery,page));
		get.addHeader("ApiKey", getApiKey());
		
		if (getAuthInfo() != null)
			get.addHeader("Authorization","Basic " + getAuthInfo());
		
		try 
		{
			HttpResponse response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == 200)
			{
				String entity = EntityUtils.toString(response.getEntity());
				ArrayList<Card>arrayList = new  GsonBuilder().setDateFormat("yyyy-mm-dd'T'HH:mm:ss")
										.create()
										.fromJson(entity,new TypeToken<ArrayList<Card>>(){}.getType());
				return arrayList;
			}
			if (response.getStatusLine().getStatusCode() == 404)
				throw new NotFoundException("Http 404:" + EntityUtils.toString(response.getEntity()));
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
         
         return buffer.toString();
	}//end buildUrl method
	
}//end HttpContactRequest class
