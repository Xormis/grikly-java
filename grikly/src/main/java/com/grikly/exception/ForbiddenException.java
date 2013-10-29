package com.grikly.exception;

/**
 * This Class is a Runtime Exception
 * that is thrown when HTTP 403 response
 * occurs.
 * @author mario
 */
public class ForbiddenException extends RuntimeException{

	private static final long serialVersionUID = 2567848959722211717L;
	private final String message;
	
	/**
	 * Default Constructor
	 * @author mario
	 * @param message 
	 */
	public ForbiddenException(String message) 
	{
		this.message = message;
	}//end constructor
	
	@Override
	public String getMessage() 
	{
		StringBuffer buffer = new StringBuffer("HTTP 403: ");
		buffer.append(message);
		return buffer.toString();
	}//end getMessage method
	
}//end ForbiddenException
