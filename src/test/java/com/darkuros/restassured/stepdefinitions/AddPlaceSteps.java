package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.utils.ConfigReader;

import com.darkuros.restassured.payloadfactory.PayloadFactory;

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
		RestAssured.baseURI = ConfigReader.getProperty("base.url");
		// Create a request specification with query parameters and headers
		commonSteps.setReq(RestAssured.given().log().ifValidationFails()
				.queryParam(ConfigReader.getProperty("api.key.name"), ConfigReader.getProperty("api.key.value"))
				.header("Content-Type", "application/json")
				.body(PayloadFactory.createPlacePayload(name, address, language)));
	}

	@Then("store place_id from response")
	public void storePlaceId() {
		commonSteps.setPlaceId(commonSteps.getRes().jsonPath().getString("place_id"));
	}
}
