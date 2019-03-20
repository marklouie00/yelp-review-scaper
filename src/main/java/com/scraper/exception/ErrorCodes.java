package com.scraper.exception;

/**
 * 
 * @author mark.louie.perez
 * @since 3.05.2019
 *
 */
public enum ErrorCodes {

	
	E_0000("E-0000", "Unexpected error occurred"),
	E_0012("E-0012", "Yelp page unrechable"),
	E_0013("E-0013", "Invalid URL"),
	E_0014("E-0014", "Unable to parse URL"),
	E_0015("E-0015", "Unexpected error occurred using google vision API");

	private String key;
	private String value;

	ErrorCodes(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	

}
