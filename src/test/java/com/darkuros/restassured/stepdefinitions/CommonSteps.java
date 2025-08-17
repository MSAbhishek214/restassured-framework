package com.darkuros.restassured.stepdefinitions;

import static org.hamcrest.Matchers.equalTo;

import com.darkuros.restassured.utils.APIResources;

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
		// Convert the resource to a valid API enum
		APIResources apiResource = APIResources.valueOf(resource);
		switch (method.toUpperCase()) {
		case "POST":
			res = req.when().post(apiResource.getResource());
			break;
		case "GET":
			res = req.when().get(apiResource.getResource());
			break;
		case "PUT":
			res = req.when().put(apiResource.getResource());
			break;
		case "DELETE":
			res = req.when().delete(apiResource.getResource());
			break;
		default:
			throw new IllegalArgumentException("Unsupported HTTP method: " + method);
		}
	}

	// Validation steps to check the status code
	@Then("the API call is successful with status code {int}")
	public void validateStatusCode(int code) {
		// Validate that the response status code matches the expected code
		res.then().statusCode(code);
	}

	// Validate a specific field in the response body
	@Then("{string} in response body is {string}")
	public void validateFieldInResponse(String key, String expectedValue) {
		// Validate specified key in the response body matches the expected value
		res.then().body(key, equalTo(expectedValue));
	}

}
