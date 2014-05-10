package com.grikly.request;

import com.grikly.exception.GriklyException;


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
	public T execute() throws GriklyException;
	
}//end Request interface
