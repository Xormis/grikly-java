package com.grikly;

import com.grikly.request.IHttpRequest;


public class GriklyThread<E,T> implements Runnable{

	private final ResponseListener<T> response;
	private final IHttpRequest<E,T> request;
	private final URL url;
	
	protected GriklyThread (IHttpRequest<E,T> listener,ResponseListener<T> response,URL url)
	{
		this.response = response;
		this.request = listener;
		this.url = url;
	}
	
	
	public void run() 
	{
		T result;
		synchronized (request) 
		{
			result = (T) request.execute (url);	
			response.response(result);
		}
		
	}//end run method 
	
}//end GriklyThread class
