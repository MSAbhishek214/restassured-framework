package com.darkuros.restassured.stepdefinitions;

import static com.darkuros.restassured.utils.FrameworkConstants.BASE_URL;
import static com.darkuros.restassured.utils.FrameworkConstants.API_KEY_NAME;
import static com.darkuros.restassured.utils.FrameworkConstants.API_KEY_VALUE;

import com.darkuros.restassured.payloads.PayloadBuilder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;

public class AddPlaceSteps {

	private final CommonSteps commonSteps;

	public AddPlaceSteps(CommonSteps commonSteps) {
		// Initialize the request specification and response
		this.commonSteps = commonSteps;
	}

	@Given("Add Place Payload with name {string}, language {string}, and address {string}")
	public void addPlacePayload(String name, String language, String address) {
		// Base URI for the API
		RestAssured.baseURI = BASE_URL;
		// Create a request specification with query parameters and headers
		commonSteps.setReq(RestAssured.given().log().ifValidationFails().queryParam(API_KEY_NAME, API_KEY_VALUE)
				.header("Content-Type", "application/json")
				.body(PayloadBuilder.addPlacePayload(name, language, address)));
	}

	@Then("store place_id from response")
	public void storePlaceId() {
		commonSteps.setPlaceId(commonSteps.getRes().jsonPath().getString("place_id"));
	}
}
