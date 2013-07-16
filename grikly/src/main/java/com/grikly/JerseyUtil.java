package com.grikly;

import com.sun.jersey.api.client.Client;

public class JerseyUtil {

	private static final Client CLIENT = Client.create();
	
	private JerseyUtil (){}
	
	/**
	 * Gets instance of Jersey Client.
	 * [Note] Returns Singleton.
	 * @author Mario Dennis
	 * @return Client
	 */
	public static Client getClient ()
	{
		return CLIENT;
	}//end getClient method
	
}//end JerseyUtil class
