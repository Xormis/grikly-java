package com.grikly;

import com.grikly.model.Card;
import com.grikly.model.LoginModel;
import com.grikly.model.NewUser;
import com.grikly.model.User;
import com.grikly.request.HttpGetRequest;
import com.grikly.request.HttpPostRequest;
import com.grikly.request.IHttpRequest;


public class Grikly{

	private final String apiKey;
	
	
	/**
	 * @author Mario Dennis
	 * @param apiKey user API Key
	 * @param response 
	 */
	public Grikly (String apiKey)
	{
		this.apiKey = apiKey;
	}//end constructor method
	
	
	
	/**
	 * Gets API key.
	 * @author Mario Dennis
	 */
	public String getApiKey ()
	{
		return apiKey;
	}//end getApiKey method
	
	
	/**
	 * Fetch User.
	 * @author Mario Dennis
	 * @param userId
	 * @param response
	 */
	public void fetchUser (int userId, ResponseListener<User> response)
	{
		if (userId <= 0)
			throw new IllegalArgumentException("User id must be greater than zero");
		
		if (response == null)
			throw new NullPointerException("Null Argument Supplied");
		
		IHttpRequest<Integer, User> request = new HttpGetRequest<Integer, User>(getApiKey(), User.class, userId);
		GriklyClient<Integer, User> client = new GriklyClient<Integer, User>(request, response, URL.USER);
		client.execute();
	}//end fetchUser method
	
	
	
	/**
	 * Get a valid User by Email and Password.
	 * @author Mario Dennis
	 * @param model
	 * @param response
	 */
	public void fetchValidUser (LoginModel model,ResponseListener<User> response)
	{
		if (model == null || response == null)
			throw new NullPointerException("Null Argument Supplied");
		
		IHttpRequest<LoginModel, User> request = new HttpPostRequest<LoginModel, User>(getApiKey(), model,User.class);
		GriklyClient<LoginModel, User> client = new GriklyClient<LoginModel, User>(request, response, URL.ACCOUNT_LOGIN);
		client.execute();
	}//end fetchValidUser method
	
	
	
	/**
	 * Registers new User.
	 * @param newUser 
	 * @param response
	 */
	public void register (NewUser newUser,ResponseListener<User> response)
	{
		if (newUser == null || response == null)
			throw new NullPointerException("Null Argument Supplied");
		
		IHttpRequest<NewUser, User> request = new HttpPostRequest<NewUser, User>(getApiKey(), newUser, User.class);
		GriklyClient<NewUser, User> client = new GriklyClient<NewUser, User>(request, response, URL.ACCOUNT_REGISTER);
		client.execute();
	}//end register method
	
	
	
	/**
	 * Check if email exists.
	 * @author Mario Dennis
	 */
	public void emailExist (String email, ResponseListener<Boolean> response)
	{
		if (email == null || response == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpGetRequest<String, Boolean> request = new HttpGetRequest<String, Boolean>(email, Boolean.class, null);
		request.addQueryParam("Email", email);
		GriklyClient<String, Boolean> client = new GriklyClient<String, Boolean>(request, response, URL.ACCOUNT_EMAIL_CHECK);
		client.execute();
	}//end emailExist method
	
	
	
	/**
	 * @author Mario Dennis
	 * @param cardId
	 * @param response
	 */
	public void fetchCard (int cardId,ResponseListener<Card> response)
	{
		if (cardId <= 0)
			throw new IllegalArgumentException("User id must be greater than zero");
		
		if (response == null)
			throw new NullPointerException("Null Argument Supplied");
		
		IHttpRequest<Integer, Card> request = new HttpGetRequest<Integer, Card>(getApiKey(),Card.class,cardId);
		GriklyClient<Integer, Card> client = new GriklyClient<Integer, Card>(request, response, URL.CARD);
		client.execute();
	}//end emailExist method
	
	
	
	/**
	 * 
	 * @param card
	 * @param response
	 */
	public void createCard (Card card,ResponseListener<Card> response)
	{
		if (card == null || response == null)
			throw new NullPointerException("Null Argument Supplied");
		
		IHttpRequest<Card, Card> request = new HttpPostRequest<Card, Card>(getApiKey(), card, Card.class);
		GriklyClient<Card, Card> client = new GriklyClient<Card, Card>(request, response, URL.CARD_BASE);
		client.execute();
	}//end createCard method
	
}//end  Grikly class
