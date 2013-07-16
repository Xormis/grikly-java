package com.grikly;

/**
 * ResponseListener interface is used as a 
 * Callback Hander.
 * @author Mario Dennis
 * @param <T>
 */
public interface ResponseListener <T> {

	/**
	 * Response callback method.
	 * @author Mario Dennis
	 * @param result
	 */
	public void response (T result);
	
}//end IRespons interface
