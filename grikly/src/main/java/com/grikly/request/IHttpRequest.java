package com.grikly.request;

/**
 * HTTP Request Interface that all request class
 * must implement.
 * @author Mario Dennis
 * @param <E> element type for data sending in request 
 * @param <T> return type.
 */
public interface IHttpRequest<E,T>{

	/**
	 * Execute a HTTP Request.
	 * @author Mario Dennis
	 * @param url
	 * @return
	 */
	public T execute();
	
}//end IHttpRequest interface
