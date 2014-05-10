package com.grikly.exception;

/**
 * An exception class that will be thrown when 
 * GriklyAPI calls have failed.
 * @author mario
 */
public class GriklyException extends Exception{

	private static final long serialVersionUID = 1L;
	private final String message;
	
	/**
	 * Default Constructor
	 * @param message
	 */
	public GriklyException(String message) 
	{
		this.message = message;
	}//end constructor
	
	@Override
	public String getMessage() 
	{
		return message;
	}
}//end GriklyException class
