package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.payloadfactory.PayloadFactory;
import com.darkuros.restassured.utils.APIManager;
import com.darkuros.restassured.utils.JsonDataReader;
import com.google.gson.JsonObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

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
		scenarioContext
				.setReq(apiManager.getRequestSpec().body(PayloadFactory.createPlacePayload(name, address, language)));
	}

	@Given("Add Place Payload from file {string}")
	public void addPlacePayload(String filename) {
		JsonObject jsonData = new JsonDataReader().readTestData(filename);
		scenarioContext.setReq(apiManager.getRequestSpec().body(jsonData.toString()));
	}

	@Then("store place_id from response")
	public void storePlaceId() {
		String placeIdFromResponse = scenarioContext.getRes().jsonPath().getString("place_id");
		scenarioContext.setPlaceId(placeIdFromResponse);
		System.out.println("Place ID stored: " + placeIdFromResponse);
	}
}
