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
	public void fetchUser ()
	{
		grikly.fetchUser(1, new ResponseListener<User>() {
			
			public void response(User result) {
				Assert.assertNotNull(result);
				
			}
		});
	}//end fetchUser Test
	
	
	@Test
	public void fetchCard ()
	{
		grikly.fetchCard(1, new ResponseListener<Card>() {
			
			public void response(Card result) {
				Assert.assertNotNull(result);
				
			}
		});
	}//end fetchCard Test
	
	
	@Test
	public void emailExist ()
	{
		grikly.emailExist("mdennis876@gmail.com", new ResponseListener<Boolean>() {
			
			public void response(Boolean result) {
				Assert.assertNotNull(result);
				
			}
		});
	}//end emailExist Test
	
	
	@Test
	public void fetchValidUser () 
	{
		LoginModel model = new LoginModel();
		model.setEmail("mdennis876@gmail.com");
		model.setPassword("computer");
		
		grikly.fetchValidUser(model, new ResponseListener<User>() {
			
			public void response(User result) {
				Assert.assertNotNull(result);	
				System.out.println(result);
			}
		});
	}//end fetchValidUser Test
	
	
}//end AppTest 
