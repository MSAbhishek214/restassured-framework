package com.darkuros.restassured.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * APIManager is a utility class that manages API-related operations.
 * It provides methods to create and configure RequestSpecification and
 * ResponseSpecification objects for making API requests and validating responses.
 */
public final class APIManager {
	// Log file configuration
	private final String LOG_DIR = "target/logs/";
	private PrintStream logStream;
	private String logFileName;

	// Public no arg constructor for dependency injection by PicoContainer
	public APIManager() {
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		this.logFileName = LOG_DIR + "test-logs_" + timestamp + ".log";
		new File(LOG_DIR).mkdirs(); // Ensure the log directory exists
		try {
			this.logStream = new PrintStream(new FileOutputStream(logFileName, true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
				.addHeader("Content-Type", "application/json");

		if ("true".equalsIgnoreCase(System.getProperty("logging"))) {
			builder.addFilter(new RequestLoggingFilter(LogDetail.ALL, logStream))
					.addFilter(new ResponseLoggingFilter(LogDetail.ALL, logStream));
		}
		return builder.build();
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

	/**
	 * Returns the name of the log file where API request and response logs are
	 * stored.
	 * 
	 * @return The log file name as a String.
	 */
	public String getLogFileName() {
		return this.logFileName;
	}

}
