package com.grikly.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6777301222762033626L;

	@Override
	public String getMessage() 
	{
		return "HTTP 404 Not Found response";
	}
}
