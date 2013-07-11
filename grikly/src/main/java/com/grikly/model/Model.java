package com.grikly.model;

public abstract class Model {

	private int httpCode;
	private boolean success;
	
	/**
	 * @return the httpCode
	 */
	public int getHttpCode() 
	{
		return httpCode;
	}
	
	/**
	 * @param httpCode the httpCode to set
	 */
	public void setHttpCode(int httpCode) 
	{
		this.httpCode = httpCode;
	}
	
	
	/**
	 * @return the success
	 */
	public boolean isSuccess() 
	{
		return success;
	}
	
	
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) 
	{
		this.success = success;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Model [httpCode=" + httpCode + ", success=" + success + "]";
	}
	
}//end Model class
