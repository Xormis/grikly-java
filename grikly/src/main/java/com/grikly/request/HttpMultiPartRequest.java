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

import com.grikly.exception.GriklyException;

public final class HttpMultiPartRequest <E, T> extends AbstractHttpRequest<E, T> {

	protected HttpMultiPartRequest(HttpBuilder<E, T> builder) 
	{
		super(builder);
	}
	
	@SuppressWarnings("unchecked")
	public T execute() throws GriklyException 
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
			
			//check if request was successful
			if (response.getStatusLine().getStatusCode() > 299)
				throw new GriklyException(EntityUtils.toString(response.getEntity()));
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (response.getStatusLine().getStatusCode() == 200) ?  (T) result : null;
	}//end execute method
	
}//end HttpMultiPartRequest class
