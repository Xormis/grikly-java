package com.grikly.model;

public class LoginModel{

	private String Email;
	private String Password;
	
	//Default constructor
	public LoginModel (){}
	
	
	/**
	 * Login Model Overloaded constructor
	 * @param email
	 * @param password
	 */
	public LoginModel (String email,String password)
	{
		this.Email = email;
		this.Password = password;
	}//end constructor
	
	
	/**
	 * @return the email
	 */
	public String getEmail() 
	{
		return Email;
	}//end getEmail method

	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) 
	{
		Email = email;
	}//end setEmail method
	
	
	/**
	 * @return the password
	 */
	public String getPassword() 
	{
		return Password;
	}//end getPassword method
	
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) 
	{
		Password = password;
	}//end setPassword method
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "LoginModel [Email=" + Email + ", Password=" + Password + "]";
	}//end toString method
	
	
}//end LoginModel class
