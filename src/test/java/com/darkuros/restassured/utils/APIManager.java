package com.darkuros.restassured.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * APIManager is a utility class that manages API-related operations. It
 * provides methods to create and configure RequestSpecification and
 * ResponseSpecification objects for making API requests and validating
 * responses.
 */
public final class APIManager {
	private ByteArrayOutputStream requestResponseLog = new ByteArrayOutputStream();
	private PrintStream logStream = new PrintStream(requestResponseLog);

	// Public no arg constructor for dependency injection by PicoContainer
	public APIManager() {
	}

	/**
	 * Constructs and returns a RequestSpecification object with predefined
	 * configurations such as base URI, query parameters, and headers. If logging is
	 * enabled via system properties, it also adds request and response logging
	 * filters to capture detailed logs of API interactions.
	 * 
	 * @return A configured RequestSpecification object for making API requests.
	 */
	public RequestSpecification getRequestSpec() {
		RequestSpecBuilder builder = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base.url"))
				.addQueryParam(ConfigReader.getProperty("api.key.name"), ConfigReader.getProperty("api.key.value"))
				.addHeader("Content-Type", "application/json")
				.addFilter(new RequestLoggingFilter(LogDetail.ALL, logStream))
				.addFilter(new ResponseLoggingFilter(LogDetail.ALL, logStream));

		return builder.build();
	}

	/**
	 * Retrieves the captured request and response logs as a string.
	 * 
	 * @return A string containing the logged details of API requests and responses.
	 */
	public String getLogs() {
		return requestResponseLog.toString();
	}

	/**
	 * Constructs and returns a ResponseSpecification object with predefined
	 * configurations such as expected content type and status code.
	 * 
	 * @param statusCode The expected HTTP status code for the response.
	 * @return A configured ResponseSpecification object for validating API
	 *         responses.
	 */
	public ResponseSpecification getResponseSpec(int statusCode) {
		return new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(statusCode).build();
	}
}
