package com.grikly.request;

import java.io.IOException;
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
import com.grikly.model.Card;


public class HttpContactRequest extends HttpRequest<String, ArrayList<Card>> {
	private final String searchQuery;
	private final int page;
	protected HttpContactRequest (String searchQuery, Integer page, HttpBuilder<String,ArrayList<Card>> builder)
	{
		super(builder);
		this.searchQuery = searchQuery;
		this.page = page;
	}
	
	
	public ArrayList<Card> execute() 
	{	
		if (getPath() == null)
			throw new NullPointerException ("No Path supplied");
		
		if (getModel() == null)
			throw new NullPointerException("No Model Supplied: Enter Query");
		
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(buildUrl(searchQuery,page));
		
		get.addHeader("ApiKey", getApiKey());
		
		if (getAuthInfo() != null)
			get.addHeader("Authorization","Basic " + getAuthInfo());
		
		try 
		{
			HttpResponse response = client.execute(get);
			System.err.println(response.getStatusLine());
			if (response.getStatusLine().getStatusCode() == 200)
			{
				String entity = EntityUtils.toString(response.getEntity());
				ArrayList<Card>arrayList = new  GsonBuilder().setDateFormat("yyyy-mm-dd'T'HH:mm:ss")
										.create()
										.fromJson(entity,new TypeToken<ArrayList<Card>>(){}.getType());
				return arrayList;
			}
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
	
	
	private String buildUrl (String searchQuery,int page)
	{
		StringBuffer buffer = new StringBuffer(String.format(URL.BASE.toString(), "Contacts"));
		buffer.append("?searchText=");
		buffer.append(searchQuery);
		buffer.append("&page=");
		buffer.append(page);
		return buffer.toString();
	}
	
	
/*
	private final ResponseListener<ArrayList<Card>> response;
	private final String searchString;
	private final int page;
	private final String apiKey;
	private String authInfo;
	
	public HttpContactRequest (String searchString, int page,String apiKey,byte[] authInfo,ResponseListener<ArrayList<Card>> response)
	{
		this.response = response;
		this.searchString = searchString;
		this.apiKey = apiKey;
		this.page = page;
		
		if (authInfo != null)
			this.authInfo = new String(authInfo);
	}
	
	public void execute ()
	{
		Runnable runnable = new Runnable() {
			@SuppressWarnings("unchecked")
			public void run() {

				StringBuffer queryParm = new StringBuffer("?searchText=");
				queryParm.append(searchString);
				queryParm.append("&page=");
				queryParm.append(page);
				
				HttpClient client = new DefaultHttpClient();
				HttpGet get = new HttpGet(String.format("http://api.grik.ly/v1/Contacts%s", queryParm.toString()));	
				get.addHeader("ApiKey", apiKey);
				if (authInfo != null)
					get.addHeader("Authorization","Basic " + authInfo);
				try 
				{
					HttpResponse httpResponse = client.execute(get);
					if (httpResponse.getStatusLine().getStatusCode() == 200)
					{
						
						String result = EntityUtils.toString(httpResponse.getEntity());
						Gson gson=  new GsonBuilder().setDateFormat("yyyy-mm-dd'T'HH:mm:ss").create();
						response.response((ArrayList<Card>) gson.fromJson(result,new TypeToken<ArrayList<Card>>(){}.getType()));
					}
					if (httpResponse.getStatusLine().getStatusCode() == 403)
						throw new ForbiddenException();
					
					if (httpResponse.getStatusLine().getStatusCode() == 401)
						throw new UnauthorizedException();
					
					if (httpResponse.getStatusLine().getStatusCode() == 404)
						throw new NotFoundException();
				} catch (ClientProtocolException e) 
				{
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		};
	
		new Thread(runnable).start();
	}
	
	*/
}
