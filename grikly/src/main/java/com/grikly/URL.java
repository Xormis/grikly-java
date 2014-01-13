package com.grikly;

public enum URL {

	//BASE ("http://api.grik.ly/v1/%s");
	//BASE ("http://griklyapibeta.azurewebsites.net/v1/%s");
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
