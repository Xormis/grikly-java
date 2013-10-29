package com.grikly.exception;

/**
 * This Class is a Runtime Exception
 * that is thrown when HTTP 404 response
 * occurs.
 * @author mario
 */
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6777301222762033626L;
	private final String message;
	
	/**
	 * Default Constructor
	 * @author mario
	 * @param message
	 */
	public NotFoundException (String message)
	{
		this.message = message;
	}//end constructor 
	
	@Override
	public String getMessage() 
	{
		StringBuffer buffer = new StringBuffer("HTTP 404: ");
		buffer.append(message);
		return buffer.toString();
	}//end getMessage method
	
}//end NotFoundException class
