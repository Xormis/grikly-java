package com.grikly.model;

public class AccessToken extends AbstractModel{
	private String access_token,token_type,userName;
	private String expires,issued;
	private int expires_in;
	
	
	public String getAccess_token() {
		return access_token;
	}
	
	
	public String getToken_type() {
		return token_type;
	}
	
	
	public String getUserName() {
		return userName;
	}
	
	public int getExpires_in() {
		return expires_in;
	}
	
	
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
	
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}


	/**
	 * @return the expires
	 */
	public String getExpires() {
		return expires;
	}


	/**
	 * @param expires the expires to set
	 */
	public void setExpires(String expires) {
		this.expires = expires;
	}


	/**
	 * @return the issued
	 */
	public String getIssued() {
		return issued;
	}


	/**
	 * @param issued the issued to set
	 */
	public void setIssued(String issued) {
		this.issued = issued;
	}

	
	public boolean isExpired ()
	{
		return false;
	}

	@Override
	public String toString() {
		return String
				.format("AccessToken [access_token=%s, token_type=%s, userName=%s, expires_in=%s]",
						access_token, token_type, userName, expires_in) + super.toString();
	}

	
}
