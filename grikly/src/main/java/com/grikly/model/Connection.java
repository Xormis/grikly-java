package com.grikly.model;


public class Connection {
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
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Connection [CardId=").append(CardId)
				.append(", UserId=").append(UserId)
				.append(", UserProfileImageUri=").append(UserProfileImageUri)
				.append(", FirstName=").append(FirstName).append(", LastName=")
				.append(LastName).append(", EventMet=").append(EventMet)
				.append(", DateMet=").append(DateMet).append("]");
		return builder.toString();
	}
    
    
}//end Connection class
