package com.grikly.model;


public class Contact {
	private int CardId;
	private String EventMet;
    private String PlaceMet;
    private double LatitudeMet;
    private double LongitudeMet;
    private String DateMet;
    private String Comment;
    public String UserProfileImageUri;
    public int UserId;
    public String FirstName;
    
    
    /**
	 * @return the userProfileImageUri
	 */
	public String getUserProfileImageUri() {
		return UserProfileImageUri;
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
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}


	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return CompanyName;
	}


	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}


	public String LastName;
    public String Title;
    public String CompanyName;

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
	
	
	/**
	 * @return the eventMet
	 */
	public String getEventMet() 
	{
		return EventMet;
	}
	
	
	/**
	 * @param eventMet the eventMet to set
	 */
	public void setEventMet(String eventMet) 
	{
		EventMet = eventMet;
	}
	
	
	/**
	 * @return the placeMet
	 */
	public String getPlaceMet() 
	{
		return PlaceMet;
	}
	
	
	/**
	 * @param placeMet the placeMet to set
	 */
	public void setPlaceMet(String placeMet) 
	{
		PlaceMet = placeMet;
	}
	
	
	/**
	 * @return the latitudeMet
	 */
	public double getLatitudeMet() 
	{
		return LatitudeMet;
	}
	
	
	/**
	 * @param latitudeMet the latitudeMet to set
	 */
	public void setLatitudeMet(double latitudeMet)
	{
		LatitudeMet = latitudeMet;
	}
	
	
	/**
	 * @return the longitudeMet
	 */
	public double getLongitudeMet() 
	{
		return LongitudeMet;
	}
	
	
	/**
	 * @param longitudeMet the longitudeMet to set
	 */
	public void setLongitudeMet(double longitudeMet) 
	{
		LongitudeMet = longitudeMet;
	}
	
	
	/**
	 * @return the dateMet
	 */
	public String getDateMet()
	{
		return DateMet;
	}
	
	
	/**
	 * @param dateMet the dateMet to set
	 */
	public void setDateMet(String dateMet)
	{
		DateMet = dateMet;
	}
	
	
	/**
	 * @return the comment
	 */
	public String getComment() 
	{
		return Comment;
	}
	
	
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment)
	{
		Comment = comment;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contact [CardId=" + CardId + ", EventMet=" + EventMet
				+ ", PlaceMet=" + PlaceMet + ", LatitudeMet=" + LatitudeMet
				+ ", LongitudeMet=" + LongitudeMet + ", DateMet=" + DateMet
				+ ", Comment=" + Comment + ", UserProfileImageUri="
				+ UserProfileImageUri + ", UserId=" + UserId + ", FirstName="
				+ FirstName + ", LastName=" + LastName + ", Title=" + Title
				+ ", CompanyName=" + CompanyName + "]";
	}
    
    
}//end Contact class
