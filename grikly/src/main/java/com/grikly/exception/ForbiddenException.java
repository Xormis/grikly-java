package com.grikly.exception;

public class ForbiddenException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2567848959722211717L;
	private final String message;
	
	public ForbiddenException(String message) 
	{
		this.message = message;
	}
	
	@Override
	public String getMessage() 
	{
		return message;
	}
}
