package com.darkuros.restassured.stepdefinitions;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// This class is used to hold common steps and shared variables for the step definitions
public class CommonSteps {

	private RequestSpecification req; // Request specification for API calls
	private Response res; // Response object to hold API responses
	private String placeId; // Variable to store place ID
	
	public CommonSteps() {
		// Default constructor for dependency injection
	}

	// Getters and Setters for RequestSpecification and Response
	public RequestSpecification getReq() {
		return req;
	}

	public void setReq(RequestSpecification req) {
		this.req = req;
	}

	public Response getRes() {
		return res;
	}

	public void setRes(Response res) {
		this.res = res;
	}
	
	public String getPlaceId() {
		return placeId;
	}
	
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	// Method to set up the request specification with base URI and headers
	@When("user calls {string} with {string} http request")
	public void userCallsAPI(String resource, String method) {
		switch (method.toUpperCase()) {
		case "POST":
			res = req.when().post(resource);
			break;
		case "GET":
			res = req.when().get(resource);
			break;
		case "PUT":
			res = req.when().put(resource);
			break;
		case "DELETE":
			res = req.when().delete(resource);
			break;
		case "PATCH":
			res = req.when().patch(resource);
			break;
		default:
			throw new IllegalArgumentException("Unsupported HTTP method: " + method);
		}
	}

	// Validation steps to check the status code
	@Then("the API call is successful with status code {int}")
	public void validateStatusCode(int code) {
		Assertions.assertEquals(code, res.getStatusCode(), "Expected status code does not match actual status code.");
	}

	// Validate a specific field in the response body
	@Then("{string} in response body is {string}")
	public void validateFieldInResponse(String key, String expectedValue) {
		String actualValue = res.jsonPath().getString(key);
		Assertions.assertEquals(expectedValue, actualValue,
				"Expected value does not match actual value in response body.");
	}

}
