package com.darkuros.restassured.utils;

public enum APIResources {
	/**
	 * Enum representing API resources for Google Maps Place API.
	 */
	ADD_PLACE("/maps/api/place/add/json"), GET_PLACE("/maps/api/place/get/json"),
	DELETE_PLACE("/maps/api/place/delete/json"), UPDATE_PLACE("/maps/api/place/update/json");

	/**
	 * The resource path for the API.
	 */
	private final String resource;

	/**
	 * Constructor to initialize the API resource.
	 *
	 * @param resource The resource path for the API.
	 */
	APIResources(String resource) {
		this.resource = resource;
	}

	/**
	 * Gets the resource path for the API.
	 *
	 * @return The resource path as a String.
	 */
	public String getResource() {
		return resource;
	}

}
