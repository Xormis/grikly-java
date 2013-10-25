package com.grikly.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6777301222762033626L;
	private final String message;
	
	public NotFoundException (String message)
	{
		this.message = message;
	}
	
	@Override
	public String getMessage() 
	{
		return message;
	}
}
