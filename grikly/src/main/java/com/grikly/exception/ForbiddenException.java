package com.grikly.exception;

public class ForbiddenException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2567848959722211717L;

	@Override
	public String getMessage() 
	{
		return "HTTP 403 Forbidden response. Ensure Api Key header present";
	}
}
