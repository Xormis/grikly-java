package com.grikly;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.grikly.exception.GriklyException;
import com.grikly.model.AccessToken;
import com.grikly.model.Card;
import com.grikly.model.Connection;
import com.grikly.model.Contact;
import com.grikly.model.NewUser;
import com.grikly.model.User;
import com.grikly.model.UserCredential;
import com.grikly.model.UserInfo;
import com.grikly.request.HttpBuilder;
import com.grikly.request.Request;


public class Grikly{

	private final String apiKey;
	private AccessToken accessToken;
	
	/**
	 * Grikly Default Constructor
	 * @author Mario Dennis
	 * @param apiKey user API Key
	 * @param userCredential
	 * @exception NullPointException for null ApiKey & UserCredential
	 */
	public Grikly (String apiKey)
	{
		if (apiKey == null)
			throw new NullPointerException("Null ApiKey Supplied");
		
		this.apiKey = apiKey;
	}//end constructor method
	
	
	
	/**
	 * Gets API key.
	 * @author Mario Dennis
	 */
	private String getApiKey ()
	{
		return apiKey;
	}//end getApiKey method

	
	/**
	 * Get AccessToken
	 * @author mario
	 * @param userCredential
	 * @return AccessToken
	 * @throws GriklyException 
	 */
	public static AccessToken getAccessToken (String apiKey,UserCredential userCredential) throws GriklyException
	{
		//add parameters
		Map<String, String> params = new HashMap<String, String>();
		params.put("grant_type", "password");
		params.put("username", userCredential.getEmail());
		params.put("password", userCredential.getPassword());

		HttpBuilder<Void, AccessToken> builder = new HttpBuilder<Void, AccessToken>(AccessToken.class, apiKey);
		builder.setPath("Token");
		builder.addHttpParams(params);

		Request<Void, AccessToken> request = builder.buildHttpPost();
		return request.execute();
	}//end getAccessToken method
	
	
	/**
	 * Set AccessToken
	 * @param accessToken
	 */
	public void setAccessToken (AccessToken accessToken)
	{
		this.accessToken = accessToken;
	}//end setAccessToken method
	
	
	private AccessToken getAccessToken ()
	{
		return accessToken;
	}//end getAccessToken method
	
	
	/**
	 * Gets UserInfo
	 * @author Mario Dennis
	 * @param userCredential
	 * @return UserInfo
	 * @throws GriklyException 
	 */
	public UserInfo getUserInfo (UserCredential userCredential) throws GriklyException
	{	
		if (userCredential == null)
			throw new NullPointerException("Null UserCredential supplied");
		
		HttpBuilder<Void, UserInfo> builder = new HttpBuilder<Void, UserInfo>(UserInfo.class, getApiKey());
		builder.setPath("v1/Account/UserInfo");
		builder.setAccessToken(getAccessToken());
		
		Request<Void, UserInfo> request = builder.buildHttpGet();
		return request.execute();
	}//end getUserInfo method
	
	
	/**
	 * Logs user out
	 * @param userCredential
	 * @throws GriklyException
	 */
	public void logoutUser (UserCredential userCredential) throws GriklyException
	{
		if (userCredential == null)
			throw new NullPointerException("Null UserCredential supplied");
		

		
		HttpBuilder<Void, Void> builder = new HttpBuilder<Void, Void>(Void.class, getApiKey());
		builder.setPath("v1/Account/Logout");
		builder.setAccessToken(getAccessToken());
	
		Request<Void, Void> request = builder.buildHttpPost();
		request.execute();
	}//end logoutUser method 
	
	
	
	
	/**
	 * Get Contact
	 * @author Mario Dennis
	 * @param contact
	 * @throws GriklyException 
	 * @exception NullPointException
	 */
	public Contact getContact (UserCredential userCredential, Contact contact) throws GriklyException
	{
		if (contact == null)
			throw new NullPointerException("Null Contact supplied");
		
		if (userCredential == null)
			throw new NullPointerException("Null UserCredential supplied");
		
		HttpBuilder<Contact, Contact> builder = new HttpBuilder<Contact, Contact>(Contact.class, getApiKey());
		builder.setPath("v1/Contacts");
		builder.setModel(contact);
		builder.setAccessToken(getAccessToken());
		
		Request<Contact, Contact> request = builder.buildHttpPost();
		return request.execute();
	}//end fetchContact method
	
	
	
	
	/**
	 * Get Card
	 * @author Mario Dennis
	 * @param cardId
	 * @return Card
	 * @throws GriklyException 
	 */
	public Card getCard (int cardId) throws GriklyException
	{
		if (cardId <= 0)
			throw new IllegalArgumentException("Card Id must be greater than zero");
		
		HttpBuilder<Integer, Card> builder = new HttpBuilder<Integer, Card>(Card.class, getApiKey());
		builder.setPath(String.format("v1/Cards/%d", cardId));
		builder.setAccessToken(getAccessToken());
		
		Request<Integer, Card> request = builder.buildHttpGet();
		return request.execute();
	}//end getCard method
	
	
	
	
	/**
	 * Create card.This method requires user credentials to 
	 * authorize action.
	 * @author Mario Dennis
	 * @param card
	 * @return Card
	 * @throws GriklyException 
	 */
	public Card createCard (Card card) throws GriklyException
	{
		if (card == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<Card, Card> builder = new HttpBuilder<Card, Card>(Card.class, getApiKey());
		builder.setModel(card);
		builder.setPath("v1/Cards");
		builder.setAccessToken(getAccessToken());
		
		Request<Card, Card> request = builder.buildHttpPost();
		return request.execute();
	}//end createCard method
	
	
	/**
	 * Delete Card. This method requires user credentials to 
	 * authorize action.
	 * @param cardId
	 * @throws GriklyException 
	 */
	public String deleteCard (int cardId) throws GriklyException
	{
		if (cardId <= 0)
			throw new IllegalArgumentException("Card Id must be greater than 0");
		
		HttpBuilder<Card, String> builder = new HttpBuilder<Card, String>(String.class, getApiKey());
		builder.setPath(String.format("v1/Cards/%d", cardId));
		builder.setAccessToken(getAccessToken());
		
		Request<Card, String> request = builder.buildHttpDelete();
		return request.execute();
	}//end deleteCard method
	
	

	/**
	 * Registers new User
	 * @author Mario Dennis
	 * @param newUser
	 * @return User
	 * @throws GriklyException 
	 */
	public User register (NewUser newUser) throws GriklyException 
	{
		if (newUser == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<NewUser, User> builder = new HttpBuilder<NewUser, User>(User.class, getApiKey());
		builder.setModel(newUser);
		builder.setPath("v1/Account/Register");
		builder.setAccessToken(getAccessToken());
		
		Request<NewUser, User> request = builder.buildHttpPost();
		return request.execute();
	}//end register method
	
	
	
	
	/**
	 * Update card Asynchronously.
	 * @author Mario Dennis
	 * @param card
	 * @param response
	 * @throws GriklyException 
	 */
	public Card updateCard (Card card) throws GriklyException
	{
		if (card == null)
			throw new NullPointerException("Null Argument Supplied");
		
		HttpBuilder<Card,Card> builder = new HttpBuilder<Card, Card>(Card.class, getApiKey());
		builder.setModel(card);
		builder.setPath(String.format("Card/%d", card.getCardId()));
		builder.setAccessToken(getAccessToken());
		
		Request<Card, Card> request = builder.buildHttpPut();
		return request.execute();
	}//end updateCard method 
	
	
	
	/**
	 * Sets a Default card for User
	 * @author Mario Dennis
	 * @param userId
	 * @param cardId
	 * @param response
	 * @throws GriklyException 
	 */
	public void updateUserDefaultCard(int userId,int cardId) throws GriklyException 
	{
		if (userId <= 0 || cardId <= 0)
			throw new IllegalArgumentException("Id must be greater than zero");
		
		HttpBuilder<Card, Card> builder = new HttpBuilder<Card, Card>(Card.class, getApiKey());
		builder.setPath(String.format("Users/%d/DefaultCard?cardId=%d", userId,cardId));
		builder.setAccessToken(getAccessToken());
		
		Request<Card, Card> request = builder.buildHttpPost();
		request.execute();
	}//end setUserDefaultCard method
	
	
	
	
	/**
	 * Get Connection
	 * @author Mario Dennis
	 * @param searchString
	 * @param page
	 * @return List<Contact>
	 * @throws GriklyException 
	 */
	public List<Connection> getConnection () throws GriklyException
	{
		HttpBuilder<String, ArrayList<Connection>> builder = new HttpBuilder<String, ArrayList<Connection>>(null, getApiKey());
		builder.setPath("Contacts/All");
		builder.setAccessToken(getAccessToken());
		
		Request<String, ArrayList<Connection>> request = builder.buildHttpContactRequest();
		return request.execute();
	}//end getContact method
	
	
	
	/**
	 * Create Contact
	 * @author Mario Dennis
	 * @param contact
	 * @return Contact
	 * @throws GriklyException 
	 */
	public Contact createContact(Contact contact) throws GriklyException 
	{
		if (contact == null || contact == null)
			throw new NullPointerException("Null argument supplied");
		
		HttpBuilder<Contact, Contact> builder = new HttpBuilder<Contact, Contact>(Contact.class, getApiKey()); 
		builder.setPath("Contacts");
		builder.setModel(contact);
		builder.setAccessToken(getAccessToken());

		Request<Contact, Contact> request = builder.buildHttpPost();
		return request.execute();
	}//end createContact method 
	
	
	/**
	 * Update Contact.
	 * @author Mario Dennis
	 * @param contact
	 * @return Contact
	 * @throws GriklyException 
	 * @throws NotFoundException 
	 */
	public Contact updateContact (Contact contact) throws GriklyException 
	{
		if (contact == null)
			throw new NullPointerException("Null argument supplied");
		
		HttpBuilder<Contact, Contact> builder = new HttpBuilder<Contact, Contact>(Contact.class, getApiKey());
		builder.setModel(contact);
		builder.setPath(String.format("Contacts/%d", contact.getCardId()));
		builder.setAccessToken(getAccessToken());
		
		Request<Contact, Contact> request = builder.buildHttpPut();
		return request.execute();
	}//end updateContact method
	
	
	/**
	 * Uploads user profile image.
	 * @author Mario Dennis
	 * @param file
	 * @see v1/Account/Register
	 * @throws GriklyException 
	 */
	public void uploadProfileImage (File file) throws GriklyException 
	{
		if (file == null)
			throw new NullPointerException("Null File Argument Supplied");
		
		HttpBuilder<File,String> builder = new HttpBuilder<File, String>(String.class, getApiKey());
		builder.setPath("v1/Account/ProfileImage");
		builder.setAccessToken(getAccessToken());
		
		Request<File, String> request = builder.buildHttpMultiPartRequest(file);
		request.execute();
	}//end uploadProfileImage method
	
	
	/**
	 * Delete card
	 * @param contactId
	 * @return 
	 * @throws GriklyException 
	 */
	public String deleteContact (int contactId) throws GriklyException 
	{
		if (contactId <= 0)
			throw new IllegalArgumentException("contactId must be greater that zero");
		
		HttpBuilder<Contact, String> builder = new HttpBuilder<Contact, String>(String.class, getApiKey());
		builder.setPath(String.format("Contacts/%d", contactId));
		builder.setAccessToken(getAccessToken());
		
		Request<Contact, String> request = builder.buildHttpDelete();
		return request.execute();
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
