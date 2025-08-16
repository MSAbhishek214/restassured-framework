package com.darkuros.restassured.utils;

// Make the class final to prevent subclassing. You dont want to allow constants to be changed once they are defined.
public final class FrameworkConstants {

	private FrameworkConstants() {
		// Prevent instantiation
	}
	
	/**
	 * Base URL for the API.
	 * This is the root URL for all API requests.
	 * Also contains the API key name and value used for authentication.
	 * These constants are made static and final to ensure they are immutable and set at compile time.
	 */
	public static final String BASE_URL = "https://rahulshettyacademy.com";
	public static final String API_KEY_NAME = "key";
	public static final String API_KEY_VALUE = "qaclick123";
	
}
