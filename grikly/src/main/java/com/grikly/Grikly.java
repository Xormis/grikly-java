package com.grikly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.joda.time.DateTime;
import org.joda.time.DateMidnight.Property;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.grikly.exception.NotFoundException;
import com.grikly.model.AccessToken;
import com.grikly.model.Card;
import com.grikly.model.Connection;
import com.grikly.model.Contact;
import com.grikly.model.UserCredential;
import com.grikly.model.NewUser;
import com.grikly.model.SendCardModel;
import com.grikly.model.User;
import com.grikly.request.HttpBuilder;
import com.grikly.request.Request;

public class Grikly{

	private final String apiKey;
	private UserCredential userCredential = new UserCredential();
	
	
	/**
	 * Grikly Default Constructor
	 * @author Mario Dennis
	 * @param apiKey user API Key
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
	 * Add the credentials of the user to make authenticated 
	 * requests.
	 * @author Mario Dennis
	 * @param email
	 * @param password
	 */
	public void addValidUserCredential (String email,String password)
	{
		userCredential.setEmail(email);
		userCredential.setPassword(password);
	}//end addValidUserCredential method
	
	
	private UserCredential getUserCredential ()
	{
		return userCredential;
	}//end getUserCredential method
	
	
	/**
	 * Fetch User Asynchronously.
	 * @author Mario Dennis
	 * @param userId
	 * @param response
	 */
	public void fetchUser (int userId, ResponseListener<User> response) throws NotFoundException
	{
		if (userId <= 0)
			throw new IllegalArgumentException("User id must be greater than zero");
		
		if (response == null)
			throw new NullPointerException("Null Argument Supplied");

		HttpBuilder<Integer, User> builder = new HttpBuilder<Integer, User>(User.class, getApiKey());
		builder.setPath(String.format("Users/%d", userId));
		builder.setAccessToken(AccessTokenManager.getAccessTokenManager()
							   .getAccessToken(getUserCredential(), getApiKey()));
		
		Request<Integer, User> request =  builder.buildHttpGet();
		
		GriklyClient<Integer, User> client = new GriklyClient<Integer, User>(request, response);
		client.execute();
	}//end fetchUser method
	
	
	
	/**
	 * Get User.
	 * @author Mario Dennis
	 * @param userId
	 * @return User
	 */
	public User getUser (int userId) 
	{
		if (userId <= 0)
			throw new IllegalArgumentException("User id must be greater than zero");
		
		HttpBuilder<Integer, User> builder = new HttpBuilder<Integer, User>(User.class, getApiKey());
		builder.setPath(String.format("Users/%d", userId));
		builder.setAccessToken(AccessTokenManager.getAccessTokenManager()
				   			   .getAccessToken(getUserCredential(), getApiKey()));
		
		Request<Integer, User> request = builder.buildHttpGet();
		return request.execute();
	}//end getUser method 
	
	
	
	
	/**
	 * Fetch Card Asynchronously.
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
		
		HttpBuilder<Integer, Card> builder = new HttpBuilder<Integer, Card>(Card.class, getApiKey());
		builder.setPath(String.format("Cards/%d", cardId));
		
		
		Request<Integer, Card> request = builder.buildHttpGet();
		GriklyClient<Integer, Card> client = new GriklyClient<Integer, Card>(request, response);
		client.execute();
	}//end emailExist method
	
	
	/**
	 * Get Card
	 * @author Mario Dennis
	 * @param cardId
	 * @return Card
	 */
	public Card getCard (int cardId)
	{
		if (cardId <= 0)
			throw new IllegalArgumentException("Card Id must be greater than zero");
		
		HttpBuilder<Integer, Card> builder = new HttpBuilder<Integer, Card>(Card.class, getApiKey());
		builder.setPath(String.format("Cards/%d", cardId));
		
		Request<Integer, Card> request = builder.buildHttpGet();
		return request.execute();
	}//end getCard method
	
		
	/**
	 * Check if email exists Asynchronously.
	 * @author Mario Dennis
	 */
	public void emailExist (String email, ResponseListener<Boolean> response)
	{
		if (email == null || response == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<String, Boolean> builder = new HttpBuilder<String, Boolean>(Boolean.class,getApiKey())
													.setPath(String.format("Account/EmailExist?Email=%s", email));
		
		Request<String, Boolean> request = builder.buildHttpGet();
		GriklyClient<String, Boolean> client = new GriklyClient<String, Boolean>(request, response);
		client.execute();
	}//end emailExist method
	
	
	/**
	 *  Check if email exists 
	 * @author Mario Dennis
	 * @return Boolean
	 */
	public boolean emailExist (String email)
	{
		if (email == null)
			throw new NullPointerException("Null Argument Supplied");
		

		HttpBuilder<String, Boolean> builder = new HttpBuilder<String, Boolean> (Boolean.class,getApiKey());
		builder.setPath(String.format("Account/EmailExist?Email=%s", email));
		
		Request<String, Boolean> request = builder.buildHttpGet();
		return request.execute();
	}//end isEmailExist method
	
	
	
	/**
	 * Create Card Asynchronously.
	 * @param card
	 * @param response
	 */
	public void createCard (Card card,ResponseListener<Card> response)
	{
		if (card == null || response == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<Card, Card> builder = new HttpBuilder<Card, Card>(Card.class, getApiKey());
		builder.setModel(card);
		builder.setPath("Cards");
			
		Request<Card, Card> request = builder.buildHttpPost();
		GriklyClient<Card, Card> client = new GriklyClient<Card, Card>(request, response);
		client.execute();
	}//end createCard method
	
	
	/**
	 * Create card.This method requires user credentials to 
	 * authorize action.
	 * @author Mario Dennis
	 * @param card
	 * @return
	 */
	public Card createCard (Card card)
	{
		if (card == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<Card, Card> builder = new HttpBuilder<Card, Card>(Card.class, getApiKey());
		builder.setModel(card);
		builder.setPath("Cards");
		
		Request<Card, Card> request = builder.buildHttpPost();
		return request.execute();
	}//end createCard method
	
	
	
	/**
	 * Delete Card Asynchronously.
	 * @author Mario Dennis
	 * @param cardId
	 * @param response
	 */
	public void deleteCard (int cardId, ResponseListener<String> response)
	{
		if (cardId <= 0)
			throw new IllegalArgumentException("Card Id must be greater than 0");
		
		if (response == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<Card, String> builder  = new HttpBuilder<Card, String>(String.class, getApiKey());
		builder.setPath(String.format("Cards/%d", cardId));
		
		Request<Card, String> request = builder.buildHttpDelete();
		GriklyClient<Card,String> client = new GriklyClient<Card,String>(request, response);
		client.execute();
	}//end deleteCard method 
	
	
	/**
	 * Delete Card. This method requires user credentials to 
	 * authorize action.
	 * @param cardId
	 */
	public String deleteCard (int cardId)
	{
		if (cardId <= 0)
			throw new IllegalArgumentException("Card Id must be greater than 0");
		
		HttpBuilder<Card, String> builder = new HttpBuilder<Card, String>(String.class, getApiKey());
		builder.setPath(String.format("Cards/%d", cardId));
		
		Request<Card, String> request = builder.buildHttpDelete();
		return request.execute();
	}//end deleteCard method
	
	
	/**
	 * Get a valid User by Email and Password Asynchronously..
	 * @author Mario Dennis
	 * @param model
	 * @param response
	 */
	public void fetchValidUser (UserCredential model,ResponseListener<User> response)
	{
		if (model == null || response == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<UserCredential, User> builder = new HttpBuilder<UserCredential, User>(User.class, getApiKey());
		builder.setModel(model);
		builder.setPath("Account/Login");
		
		Request<UserCredential, User> request = builder.buildHttpPost();
		GriklyClient<UserCredential, User> client = new GriklyClient<UserCredential, User>(request, response);
		client.execute();
	}//end fetchValidUser method
	
	
	/**
	 * Get a valid User by Email and Password ..
	 * @author Mario Dennis
	 * @param model
	 * @param response
	 */
	public User getValidUser (UserCredential model)
	{
		if (model == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<UserCredential, User> builder = new HttpBuilder<UserCredential, User>(User.class, getApiKey());
		builder.setModel(model);
		builder.setPath("Account/Login");
		
		Request<UserCredential, User> request = builder.buildHttpPost();
		return request.execute();
	}//end getValidUser method
	
	
	
	
	/**
	 * Registers new User Asynchronously..
	 * @param newUser 
	 * @param response
	 */
	public void register (NewUser newUser,ResponseListener<User> response)
	{
		if (newUser == null || response == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<NewUser, User> builder = new HttpBuilder<NewUser, User> (User.class,getApiKey());
		builder.setModel(newUser);
		builder.setPath("Account/Register");
		
		Request<NewUser, User> request = builder.buildHttpPost();
		GriklyClient<NewUser, User> client = new GriklyClient<NewUser, User>(request, response);
		client.execute();
	}//end register method
	

	/**
	 * Registers new User
	 * @author Mario Dennis
	 * @param newUser
	 * @return User
	 */
	public User register (NewUser newUser) 
	{
		if (newUser == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<NewUser, User> builder = new HttpBuilder<NewUser, User>(User.class, getApiKey());
		builder.setModel(newUser);
		builder.setPath("Account/Register");
		
		Request<NewUser, User> request = builder.buildHttpPost();
		return request.execute();
	}//end register method
	
	
	
	/**
	 * Update card Asynchronously.
	 * @author Mario Dennis
	 * @param card
	 * @param response
	 */
	public void updateCard (Card card,ResponseListener<Card> response)
	{
		if (card == null || response == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<Card, Card> builder = new HttpBuilder<Card, Card>(Card.class, getApiKey());
		builder.setModel(card);
		builder.setPath(String.format("Cards/%d", card.getCardId()));
		
		Request<Card, Card> request = builder.buildHttpPut();
		GriklyClient<Card, Card> client = new GriklyClient<Card, Card>(request, response);
		client.execute();
	}//end updateCard method 
	
	
	/**
	 * Update card Asynchronously.
	 * @author Mario Dennis
	 * @param card
	 * @param response
	 */
	public Card updateCard (Card card)
	{
		if (card == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<Card,Card> builder = new HttpBuilder<Card, Card>(Card.class, getApiKey());
		builder.setModel(card);
		builder.setPath(String.format("Card/%d", card.getCardId()));
		
		Request<Card, Card> request = builder.buildHttpPut();
		return request.execute();
	}//end updateCard method 
	
	
	
	/**
	 * Sets a Default card for User
	 * @author Mario Dennis
	 * @param userId
	 * @param cardId
	 * @param response
	 */
	public void  updateUserDefaultCard (int userId,int cardId,ResponseListener<Card> response)
	{
		if (userId <= 0 || cardId <= 0)
			throw new IllegalArgumentException("Id must be greater than zero");
		
		if (response == null)
			throw new NullPointerException("Null ResponseListener instance supplied");
	
		HttpBuilder<Card, Card> builder = new HttpBuilder<Card, Card>(Card.class, getApiKey());
		builder.setPath(String.format("Users/%d/DefaultCard?cardId=%d", userId,cardId));
		
		Request<Card, Card> request = builder.buildHttpPost();
		GriklyClient<Card, Card> client = new GriklyClient<Card, Card> (request,response);
		client.execute();
	}//end setUserDefaultCard method
	
	
	/**
	 * Sets a Default card for User
	 * @author Mario Dennis
	 * @param userId
	 * @param cardId
	 * @param response
	 */
	public void updateUserDefaultCard(int userId,int cardId) 
	{
		if (userId <= 0 || cardId <= 0)
			throw new IllegalArgumentException("Id must be greater than zero");
		
		HttpBuilder<Card, Card> builder = new HttpBuilder<Card, Card>(Card.class, getApiKey());
		builder.setPath(String.format("Users/%d/DefaultCard?cardId=%d", userId,cardId));
		
		Request<Card, Card> request = builder.buildHttpPost();
		request.execute();
	}//end setUserDefaultCard method
	
	
	
	/**
	 * Send Card Asynchronously.
	 * @author Mario Dennis
	 * @param cardId
	 * @param model
	 * @param response
	 */
	public void sendCard (int cardId,SendCardModel model,ResponseListener<Card> response) 
	{
		if (cardId <= 0)
			throw new IllegalArgumentException("Id must be greater than 0");
		
		if ( model == null || response == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<SendCardModel, Card> builder = new HttpBuilder<SendCardModel, Card>(Card.class, getApiKey());
		builder.setModel(model);
		builder.setPath(String.format("Cards/%d/",cardId));
		
		Request<SendCardModel, Card> request = builder.buildHttpPost();
		GriklyClient<SendCardModel, Card> client = new GriklyClient<SendCardModel, Card>(request, response);
		client.execute();
	}//end sendCard method
	
	
	
	/**
	 * Get Connection
	 * @author Mario Dennis
	 * @param searchString
	 * @param page
	 * @return List<Contact>
	 */
	public List<Connection> getConnection ()
	{
		HttpBuilder<String, ArrayList<Connection>> builder = new HttpBuilder<String, ArrayList<Connection>>(null, getApiKey());
		builder.setPath("Contacts/All");
		
		Request<String, ArrayList<Connection>> request = builder.buildHttpContactRequest();
		return request.execute();
	}//end getContact method
	
	
	/**
	 * Get Connection
	 * @author Mario Dennis
	 * @param searchString
	 * @param page
	 */
	public void getConnection(ResponseListener<ArrayList<Connection>> response)
	{
		HttpBuilder<String, ArrayList<Connection>> builder = new HttpBuilder<String, ArrayList<Connection>>(null, getApiKey());
		builder.setPath("Contacts/All");
		
		Request<String, ArrayList<Connection>> request = builder.buildHttpContactRequest();
	
		GriklyClient<String, ArrayList<Connection>> client = new GriklyClient<String, ArrayList<Connection>>(request, response);
		client.execute();
	}//end getContact method
	
	
	
	
	/**
	 * Create Contact Asynchronously.
	 * @author Mario Dennis
	 * @param contact
	 * @return Contact
	 */
	public void createContact(Contact contact,ResponseListener<Contact> response)
	{
		if (contact == null)
			throw new NullPointerException("Null argument supplied");
		
		HttpBuilder<Contact, Contact> builder = new HttpBuilder<Contact, Contact>(Contact.class, getApiKey()); 
		builder.setPath("Contacts");
		builder.setModel(contact);
		
		Request<Contact, Contact> request = builder.buildHttpPost();
		GriklyClient<Contact, Contact> client = new GriklyClient<Contact, Contact>(request, response);
		client.execute();
	}//end createContact method 
	
	
	
	/**
	 * Create Contact
	 * @author Mario Dennis
	 * @param contact
	 * @return Contact
	 */
	public Contact createContact(Contact contact) 
	{
		if (contact == null || contact == null)
			throw new NullPointerException("Null argument supplied");
		
		HttpBuilder<Contact, Contact> builder = new HttpBuilder<Contact, Contact>(Contact.class, getApiKey()); 
		builder.setPath("Contacts");
		builder.setModel(contact);

		Request<Contact, Contact> request = builder.buildHttpPost();
		return request.execute();
	}//end createContact method 
	
	
	/**
	 * Update Contact Asynchronously.
	 * @author Mario Dennis
	 * @param contact
	 * @return Contact
	 */
	public void updateContact (Contact contact,ResponseListener<Contact> response)
	{
		if (contact == null)
			throw new NullPointerException("Null argument supplied");
		
		HttpBuilder<Contact, Contact> builder = new HttpBuilder<Contact, Contact>(Contact.class, getApiKey());
		builder.setModel(contact);
		builder.setPath(String.format("Contacts/%d", contact.getCardId()));
		
		Request<Contact, Contact> request = builder.buildHttpPut();
		GriklyClient<Contact, Contact> client = new GriklyClient<Contact, Contact>(request, response);
		client.execute();
	}//end updateContact method
	
	
	/**
	 * Update Contact.
	 * @author Mario Dennis
	 * @param contact
	 * @return Contact
	 * @throws NotFoundException 
	 */
	public Contact updateContact (Contact contact) 
	{
		if (contact == null)
			throw new NullPointerException("Null argument supplied");
		
		HttpBuilder<Contact, Contact> builder = new HttpBuilder<Contact, Contact>(Contact.class, getApiKey());
		builder.setModel(contact);
		builder.setPath(String.format("Contacts/%d", contact.getCardId()));
		
		Request<Contact, Contact> request = builder.buildHttpPut();
		return request.execute();
	}//end updateContact method
	
	
	/**
	 * Uploads user profile image.
	 * @author Mario Dennis
	 * @param userId
	 * @param file
	 */
	public void uploadProfileImage (int userId,File file,ResponseListener<String> response) 
	{
		if (userId <= 0)
			throw new IllegalArgumentException("User Id must be greater than 0");
		
		if (file == null)
			throw new NullPointerException("Null File Argument Supplied");
		
		if (response == null)
			throw new NullPointerException("Null ResponseListener Argument supplied");
		
		HttpBuilder<File,String> builder = new HttpBuilder<File, String>(String.class, getApiKey());
		builder.setPath(String.format("Users/%d/ProfileImage", userId));
		
		Request<File, String> request = builder.buildHttpMultiPartRequest(file);
		GriklyClient<File, String> client = new GriklyClient<File, String>(request, response);
		
		client.execute();
	}//end uploadProfileImage method
	
	
	/**
	 * Delete card
	 * @param contactId
	 * @return 
	 */
	public String deleteContact (int contactId) 
	{
		if (contactId <= 0)
			throw new IllegalArgumentException("contactId must be greater that zero");
		
		HttpBuilder<Contact, String> builder = new HttpBuilder<Contact, String>(String.class, getApiKey());
		builder.setPath(String.format("Contacts/%d", contactId));
		
		Request<Contact, String> request = builder.buildHttpDelete();
		return request.execute();
	}//end deleteContact method
	
	
	/**
	 * Delete card
	 * @param contactId
	 * @return
	 */
	public void deleteContact (int contactId,ResponseListener<String> response) 
	{
		if (contactId <= 0)
			throw new IllegalArgumentException("contactId must be greater that zero");
		
		if (response == null)
			throw new NullPointerException("Null ResponseListener supplied");
		
		
		HttpBuilder<Contact, String> builder = new HttpBuilder<Contact, String>(String.class, getApiKey());
		builder.setPath(String.format("Contacts/%d", contactId));
		
		Request<Contact, String> request = builder.buildHttpDelete();
		GriklyClient<Contact, String> client = new GriklyClient<Contact, String>(request, response);
		client.execute();
	}//end deleteContact method
	
	
	/**
	 * Convert to date
	 * @param date
	 * @return
	 */
	public DateTime convertToDate (String date)
	{
		DateTimeFormatter parser = ISODateTimeFormat.dateTimeNoMillis();
		return parser.parseDateTime(date+"Z");
	}//end method
	
}//end  Grikly class
