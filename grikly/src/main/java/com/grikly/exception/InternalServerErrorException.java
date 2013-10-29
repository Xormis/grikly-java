package com.grikly.exception;

/**
 * This Class is a Runtime Exception
 * that is thrown when HTTP 500 response
 * occurs.
 * @author mario
 */
public class InternalServerErrorException extends RuntimeException{
	
	private static final long serialVersionUID = -4356921154255352802L;
	private final String message;
	
	/**
	 * Default Constructor.
	 * @author mario
	 * @param message
	 */
	public InternalServerErrorException(String message) 
	{
		this.message = message;
	}//end constructor
	
	
	@Override
	public String getMessage() 
	{
		StringBuffer buffer = new StringBuffer("HTTP 500: ");
		buffer.append(message);
		return buffer.toString();
	}//end getMessage method

}//end InternalServerErrorException class
