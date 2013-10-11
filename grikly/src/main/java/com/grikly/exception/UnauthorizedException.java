package com.grikly.exception;

public class UnauthorizedException extends RuntimeException{
	
	private static final long serialVersionUID = -4428801208948198181L;

	@Override
	public String getMessage() 
	{
		return "HTTP 401 Unauthorized response";
	}

	
}
