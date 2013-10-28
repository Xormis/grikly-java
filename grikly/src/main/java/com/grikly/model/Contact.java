package com.grikly.model;


public class Contact {

	private int CardId;
	private String EventMet;
    private String PlaceMet;
    private double LatitudeMet;
    private double LongitudeMet;
    private String DateMet;
    private String Comment;
    
    
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
				+ ", Comment=" + Comment + "]";
	}
    
    
}//end Contact class
