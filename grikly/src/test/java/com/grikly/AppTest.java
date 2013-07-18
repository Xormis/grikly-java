package com.grikly;

import org.junit.Assert;

import com.grikly.model.Card;
import com.grikly.model.LoginModel;
import com.grikly.model.User;
import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest{
	private Grikly grikly = new Grikly("C049DBE3-C9E6-4176-9984-27C0119DB2D0");
	
	@Test
	public void getApiKey ()
	{
		Assert.assertNotNull(grikly.getApiKey());
	}//end getApiKey Test
	
	@Test
	public void getUser ()
	{
		User user = grikly.getUser(1);
		Assert.assertNotNull(user);
	}//end getUser Test
	
	
	@Test
	public void getCard ()
	{
		Card card = grikly.getCard(1);
		Assert.assertNotNull(card);
	}//end getCard Test
	
	
	@Test
	public void isEmailExist ()
	{
		grikly.addValidUserCredential("mdennis876@gmail.com", "computer");
		Assert.assertTrue(grikly.emailExist("mdennis876@gmail.com"));
	}//end isEmailExist Test
	
	
	@Test
	public void getValidUser ()
	{
		LoginModel model = new LoginModel();
		model.setEmail("mdennis876@gmail.com");
		model.setPassword("computer");
		grikly.addValidUserCredential("mdennis876@gmail.com", "computer");
		Assert.assertNotNull(grikly.getValidUser(model));
	}//end getValidUser Test
	
	
	public void createCardSync ()
	{
		grikly.addValidUserCredential("mdennis876@gmail.com", "computer");
		grikly.createCard(null);
	}//end createCardSync method
	
	
	public void updateCard ()
	{
		
	}//end updateCard Test
}//end AppTest 
