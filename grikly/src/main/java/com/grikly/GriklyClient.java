package com.grikly;

import com.grikly.exception.NotFoundException;
import com.grikly.request.Request;

/**
 * GriklyClient creates worker threads
 * to process HTTP Request.
 * 
 * @author Mario Dennis
 * @param <E>
 * @param <T>
 */
public class GriklyClient <E,T>{

	private final Request<E,T> request;
	private final ResponseListener<T> response;
	
	/**
	 * GriklyClient Default Constructor.
	 * @author Mario Dennis
	 * @param IHttpRequest<E,T> 
	 * @param ResponseListener<T>
	 */
	protected GriklyClient (Request<E,T> request,ResponseListener<T> response)
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
				T result = null;
				
					try {
						result = (T) request.execute ();
						response.response(result);
					} catch (NotFoundException e) {
						e.printStackTrace();
					}
					
					
			}
		};
		new Thread(thread).start();
	}//end execute method
	
}//end GriklyClient class
