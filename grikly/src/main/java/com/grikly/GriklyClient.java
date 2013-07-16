package com.grikly;

import com.grikly.request.IHttpRequest;


public class GriklyClient <E,T>{

	private final IHttpRequest<E,T> request;
	private final ResponseListener<T> response;
	
	/**
	 * @param request
	 * @param response
	 * @param url
	 */
	protected GriklyClient (IHttpRequest<E,T> request,ResponseListener<T> response)
	{
		this.request = request;
		this.response = response;
	}//end constructor
	
	

	/**
	 * Dispatch a thread to process
	 * HTTP Request.
	 * @author Mario Dennis
	 */
	public void execute ()
	{
		Runnable thread = new Runnable() 
		{
			
			public void run() 
			{
				T result = (T) request.execute ();	
				response.response(result);
			}
		};
		new Thread(thread).start();
	}//end execute method
	
}//end GriklyClient class
