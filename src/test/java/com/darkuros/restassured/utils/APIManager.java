package com.darkuros.restassured.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

/**
 * APIManager is a utility class that manages API-related operations.
 * It is currently empty but can be extended in the future to include methods
 * for managing API requests, responses, and configurations.
 */
public final class APIManager {

	// Private constructor to prevent instantiation
	private APIManager() {
	}

	// Future methods for API management can be added here
	/**
	 * Initializes the APIManager. Currently, this method does nothing but can be
	 * extended in the future.
	 */
	public static RequestSpecification getRequestSpec() {
		return new RequestSpecBuilder()
				.setBaseUri(ConfigReader.getProperty("base.url"))
				.addQueryParam(ConfigReader.getProperty("api.key.name"), ConfigReader.getProperty("api.key.value"))
				.addHeader("Content-Type", "application/json")
				.log(LogDetail.ALL)
				.build();
	}

}
