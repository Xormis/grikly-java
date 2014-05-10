package com.grikly;

public enum URL {

	BASE ("http://griklyapibeta.azurewebsites.net/%s");
	private final String url;
	
	private URL(String url)
	{
		this.url = url;
	}
	
	@Override
	public String toString ()
	{
		return url;
	}
}//end URL enum
