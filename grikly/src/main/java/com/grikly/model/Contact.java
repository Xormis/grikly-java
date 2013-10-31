package com.grikly.model;

public class Contact {

	 public int CardId;
     public String Comment;
     public String DateMet;
     public String EventMet;
     public double LatitudeMet;
     public double LongitudeMet;
     public String PlaceMet;
	/**
	 * @return the cardId
	 */
	public int getCardId() {
		return CardId;
	}
	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(int cardId) {
		CardId = cardId;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return Comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		Comment = comment;
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
	 * @return the latitudeMet
	 */
	public double getLatitudeMet() {
		return LatitudeMet;
	}
	/**
	 * @param latitudeMet the latitudeMet to set
	 */
	public void setLatitudeMet(double latitudeMet) {
		LatitudeMet = latitudeMet;
	}
	/**
	 * @return the longitudeMet
	 */
	public double getLongitudeMet() {
		return LongitudeMet;
	}
	/**
	 * @param longitudeMet the longitudeMet to set
	 */
	public void setLongitudeMet(double longitudeMet) {
		LongitudeMet = longitudeMet;
	}
	/**
	 * @return the placeMet
	 */
	public String getPlaceMet() {
		return PlaceMet;
	}
	/**
	 * @param placeMet the placeMet to set
	 */
	public void setPlaceMet(String placeMet) {
		PlaceMet = placeMet;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [CardId=").append(CardId).append(", Comment=")
				.append(Comment).append(", DateMet=").append(DateMet)
				.append(", EventMet=").append(EventMet)
				.append(", LatitudeMet=").append(LatitudeMet)
				.append(", LongitudeMet=").append(LongitudeMet)
				.append(", PlaceMet=").append(PlaceMet).append("]");
		return builder.toString();
	}
     
     
}//end Contact class
