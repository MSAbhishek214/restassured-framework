package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.payloadfactory.PayloadFactory;
import com.darkuros.restassured.utils.APIManager;
import com.darkuros.restassured.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;

public class AddPlaceSteps {

	private final ScenarioContext scenarioContext;
	private final APIManager apiManager; // This gets injected by PicoContainer at runtime.

	public AddPlaceSteps(ScenarioContext scenarioContext, APIManager apiManager) {
		// Initialize the request specification and response
		this.scenarioContext = scenarioContext;
		this.apiManager = apiManager;
	}

	@Given("Add Place Payload with name {string}, language {string}, and address {string}")
	public void addPlacePayload(String name, String language, String address) {
		// Base URI for the API
		RestAssured.baseURI = ConfigReader.getProperty("base.url");
		// Create a request specification with query parameters and headers
		scenarioContext
				.setReq(apiManager.getRequestSpec().body(PayloadFactory.createPlacePayload(name, address, language)));
	}

	@Then("store place_id from response")
	public void storePlaceId() {
		scenarioContext.setPlaceId(scenarioContext.getRes().jsonPath().getString("place_id"));
	}
}
