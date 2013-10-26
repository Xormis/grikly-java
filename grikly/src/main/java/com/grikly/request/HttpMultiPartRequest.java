package com.grikly.request;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.grikly.URL;

public final class HttpMultiPartRequest <E, T> extends HttpRequest<E, T> {

	public HttpMultiPartRequest(HttpBuilder<E, T> builder) 
	{
		super(builder);
	}
	
	@SuppressWarnings("unchecked")
	public T execute() 
	{
		if (getPath() == null)
			throw new NullPointerException("No path supplied");
		
		if (getModel() == null)
			throw new NullPointerException("No model supplied");
		
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(String.format(URL.BASE.toString(), getPath()));
		
		post.addHeader("ApiKey",getApiKey());
		
		// add Basic Auth 
		if (getAuthInfo() != null)
			post.addHeader("Authorization","Basic " + getAuthInfo());
		
		ContentBody contentBody = new FileBody((File) getModel());
		
		MultipartEntity multipartEntity = new MultipartEntity();
		multipartEntity.addPart("file",contentBody);
		post.setEntity(multipartEntity);
	
		try {
			HttpResponse response = client.execute(post);
			
			if (response.getStatusLine().getStatusCode() == 200)
			{
				String result = EntityUtils.toString(response.getEntity());
				return (T) result;
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}//end execute method
	
}//end HttpMultiPartRequest class
