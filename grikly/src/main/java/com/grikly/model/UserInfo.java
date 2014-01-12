package com.grikly.model;

public class UserInfo extends AbstractModel {

	  private String Email,LoginProvider,FirstName,LastName,ProfileImageUrl,UserId;
	  private int ContactsCount,CardsCount;
	  private boolean HasRegistered;


	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}


	/**
	 * @return the loginProvider
	 */
	public String getLoginProvider() {
		return LoginProvider;
	}


	/**
	 * @param loginProvider the loginProvider to set
	 */
	public void setLoginProvider(String loginProvider) {
		LoginProvider = loginProvider;
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
	 * @return the profileImageUrl
	 */
	public String getProfileImageUrl() {
		return ProfileImageUrl;
	}


	/**
	 * @param profileImageUrl the profileImageUrl to set
	 */
	public void setProfileImageUrl(String profileImageUrl) {
		ProfileImageUrl = profileImageUrl;
	}


	/**
	 * @return the userId
	 */
	public String getUserId() {
		return UserId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		UserId = userId;
	}


	/**
	 * @return the contactsCount
	 */
	public int getContactsCount() {
		return ContactsCount;
	}


	/**
	 * @param contactsCount the contactsCount to set
	 */
	public void setContactsCount(int contactsCount) {
		ContactsCount = contactsCount;
	}


	/**
	 * @return the cardsCount
	 */
	public int getCardsCount() {
		return CardsCount;
	}


	/**
	 * @param cardsCount the cardsCount to set
	 */
	public void setCardsCount(int cardsCount) {
		CardsCount = cardsCount;
	}


	/**
	 * @return the hasRegistered
	 */
	public boolean isHasRegistered() {
		return HasRegistered;
	}


	/**
	 * @param hasRegistered the hasRegistered to set
	 */
	public void setHasRegistered(boolean hasRegistered) {
		HasRegistered = hasRegistered;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInfo [Email=" + Email + ", LoginProvider=" + LoginProvider
				+ ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", ProfileImageUrl=" + ProfileImageUrl + ", UserId=" + UserId
				+ ", ContactsCount=" + ContactsCount + ", CardsCount="
				+ CardsCount + ", HasRegistered=" + HasRegistered
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	  
	  

}
