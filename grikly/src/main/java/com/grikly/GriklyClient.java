package com.grikly;

import com.grikly.request.IHttpRequest;


public class GriklyClient <E,T>{

	private final IHttpRequest<E,T> request;
	private final ResponseListener<T> response;
	private final URL url;
	
	/**
	 * @param request
	 * @param response
	 * @param url
	 */
	public GriklyClient (IHttpRequest<E,T> request,ResponseListener<T> response,URL url)
	{
		this.request = request;
		this.response = response;
		this.url = url;
	}//end constructor
	
	

	/**
	 * Dispatch a thread to process
	 * HTTP Request.
	 * @author Mario Dennis
	 */
	public void execute ()
	{
		GriklyThread<E,T> thread = new GriklyThread<E,T>(request, response,url);
		new Thread(thread).start();
	}//end execute method
	
}//end GriklyClient class
