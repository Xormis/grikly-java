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

public final class HttpMultiPartRequest <E, T> extends HttpRequest<E, T> {

	protected HttpMultiPartRequest(HttpBuilder<E, T> builder) 
	{
		super(builder);
	}
	
	@SuppressWarnings("unchecked")
	public T execute() 
	{
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost();
		HttpResponse response = null;
		
		String result = null;
		try {
			
			ContentBody contentBody = new FileBody((File) getModel());
			MultipartEntity multipartEntity = new MultipartEntity();
			multipartEntity.addPart("file",contentBody);
			post.setEntity(multipartEntity);
			
			response = client.execute(prepareRequestMethod(prepareRequestMethod(post)));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (response.getStatusLine().getStatusCode() == 200) ?  (T) result : null;
	}//end execute method
	
}//end HttpMultiPartRequest class
