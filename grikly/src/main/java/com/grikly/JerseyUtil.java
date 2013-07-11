package com.grikly;

import com.sun.jersey.api.client.Client;

public class JerseyUtil {

	private static final Client CLIENT = Client.create();
	
	private JerseyUtil (){}
	
	/**
	 * Gets instance of Jersey Client.
	 * [Note] Singleton instance returned.
	 * @author Mario Dennis
	 * @return
	 */
	public static Client getClient ()
	{
		return CLIENT;
	}//end getClient method
	
}//end JerseyUtil class
