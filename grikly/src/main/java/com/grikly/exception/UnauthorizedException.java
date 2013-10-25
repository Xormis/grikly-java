package com.grikly.exception;

public class UnauthorizedException extends RuntimeException{
	
	private static final long serialVersionUID = -4428801208948198181L;
	private final String message;
	
	public UnauthorizedException(String message) 
	{
		this.message = message;
	}
	
	
	@Override
	public String getMessage() 
	{
		return message;
	}

	
}
