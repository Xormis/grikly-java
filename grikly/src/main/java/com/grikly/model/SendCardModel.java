package com.grikly.model;

import java.util.ArrayList;
import java.util.List;

public class SendCardModel {

	private List<String> Emails = new ArrayList<String>();

	/**
	 * @return the email
	 */
	public List<String> getEmail() 
	{
		return Emails;
	}//end getEmail method

	
	/**
	 * @param email the email to set
	 */
	public void setEmail(List<String> email) 
	{
		Emails = email;
	}//end getEmail method
	
	
	public void addEmail (String email)
	{
		Emails.add(email);
	}
}//end SendCardMode class
