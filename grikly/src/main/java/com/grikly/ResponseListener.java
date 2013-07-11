package com.grikly;


public interface ResponseListener <T> {

	/**
	 * Response callback method
	 * @author Mario Dennis
	 * @param result
	 */
	public void response (T result);
	
}//end IRespons interface
