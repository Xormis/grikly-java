package com.grikly.model;

public class NewUser{

	 private String FirstName;
	 private String LastName;
	 private String Email;
	 private String Password;
	 
	 //Default Constructor
	 public NewUser(){}
	 
	
	/**
	 * Constructor
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 */
	public NewUser(String firstName, String lastName, String email,String password)
	{
		super();
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Password = password;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() 
	{
		return FirstName;
	}
	
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) 
	{
		FirstName = firstName;
	}
	
	
	/**
	 * @return the lastName
	 */
	public String getLastName() 
	{
		return LastName;
	}
	
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) 
	{
		LastName = lastName;
	}
	
	
	/**
	 * @return the email
	 */
	public String getEmail() 
	{
		return Email;
	}
	
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) 
	{
		Email = email;
	}
	
	
	/**
	 * @return the password
	 */
	public String getPassword() 
	{
		return Password;
	}
	
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) 
	{
		Password = password;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "NewUser [FirstName=" + FirstName + ", LastName=" + LastName
				+ ", Email=" + Email + ", Password=" + Password + "]";
	}
	 
	 
}//end 
