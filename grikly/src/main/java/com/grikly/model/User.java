package com.grikly.model;

public class User{

	private int UserId;
    private String FirstName;
    private String LastName;
    private String Email;
    private int ContactsCount;
    private String ProfileImageUrl;
    private int CardsCount;
    private Card DefaultCard;
	
    
    /**
	 * @return the userId
	 */
	public int getUserId()
	{
		return UserId;
	}
	
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) 
	{
		UserId = userId;
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
	 * @return the contactsCount
	 */
	public int getContactsCount() 
	{
		return ContactsCount;
	}
	
	
	/**
	 * @param contactsCount the contactsCount to set
	 */
	public void setContactsCount(int contactsCount)
	{
		ContactsCount = contactsCount;
	}
	
	
	/**
	 * @return the profileImageUrl
	 */
	public String getProfileImageUrl() 
	{
		return ProfileImageUrl;
	}
	
	
	/**
	 * @param profileImageUrl the profileImageUrl to set
	 */
	public void setProfileImageUrl(String profileImageUrl)
	{
		ProfileImageUrl = profileImageUrl;
	}
	
	
	/**
	 * @return the cardsCount
	 */
	public int getCardsCount() 
	{
		return CardsCount;
	}
	
	
	/**
	 * @param cardsCount the cardsCount to set
	 */
	public void setCardsCount(int cardsCount) 
	{
		CardsCount = cardsCount;
	}
	
	
	/**
	 * @return the defaultCard
	 */
	public Card getDefaultCard() 
	{
		return DefaultCard;
	}
	
	
	/**
	 * @param defaultCard the defaultCard to set
	 */
	public void setDefaultCard(Card defaultCard) 
	{
		DefaultCard = defaultCard;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", Email=" + Email
				+ ", ContactsCount=" + ContactsCount + ", ProfileImageUrl="
				+ ProfileImageUrl + ", CardsCount=" + CardsCount
				+ ", DefaultCard=" + DefaultCard + "]";
	}
    
    
    
}//end User class
