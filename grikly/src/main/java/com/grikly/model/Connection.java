package com.grikly.model;


public class Connection extends AbstractModel{
	private int CardId;
	public int UserId;
    public String UserProfileImageUri;
    public String FirstName,LastName,EventMet,DateMet;
    
    
    /**
	 * @return the userProfileImageUri
	 */
	public String getUserProfileImageUri() {
		return UserProfileImageUri;
	}


	/**
	 * @return the eventMet
	 */
	public String getEventMet() {
		return EventMet;
	}


	/**
	 * @param eventMet the eventMet to set
	 */
	public void setEventMet(String eventMet) {
		EventMet = eventMet;
	}


	/**
	 * @return the dateMet
	 */
	public String getDateMet() {
		return DateMet;
	}


	/**
	 * @param dateMet the dateMet to set
	 */
	public void setDateMet(String dateMet) {
		DateMet = dateMet;
	}


	/**
	 * @param userProfileImageUri the userProfileImageUri to set
	 */
	public void setUserProfileImageUri(String userProfileImageUri) {
		UserProfileImageUri = userProfileImageUri;
	}


	/**
	 * @return the userId
	 */
	public int getUserId() {
		return UserId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		UserId = userId;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return FirstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return LastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * @return the cardId
	 */
	public int getCardId() 
	{
		return CardId;
	}
	
	
	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(int cardId) 
	{
		CardId = cardId;
	}


	@Override
	public String toString() {
		return String
				.format("Connection [CardId=%s, UserId=%s, UserProfileImageUri=%s, FirstName=%s, LastName=%s, EventMet=%s, DateMet=%s, getMessage()=%s, toString()=%s, getClass()=%s, hashCode()=%s]",
						CardId, UserId, UserProfileImageUri, FirstName,
						LastName, EventMet, DateMet, getError_description(),
						super.toString(), getClass(), hashCode());
	}
	
    
    
}//end Connection class
