package com.grikly.request;


/**
 * Request Interface that all request class
 * should implement.
 * @author Mario Dennis
 * @param <E> element type for data sending in request 
 * @param <T> return type.
 */
public interface Request<E,T>{

	/**
	 * Execute a HTTP Request.
	 * @author Mario Dennis
	 * @param url
	 * @return
	 */
	public T execute();
	
}//end Request interface
