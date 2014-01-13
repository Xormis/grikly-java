package com.grikly;

public enum GriklyToken {
	ACCESS_TOKEN("Access_Token"),
	EXPIRE_IN ("Expire_In"),
	USER ("User_Name"),
	ISSUED("Issued"),
	EXPIRES("Expires"),
	TOKEN_TYPE ("Token_Type");
	private final String value;
	
	private GriklyToken(String value) 
	{
		this.value = value;
	}
	
	@Override
	public String toString() 
	{
		return value;
	}
}
