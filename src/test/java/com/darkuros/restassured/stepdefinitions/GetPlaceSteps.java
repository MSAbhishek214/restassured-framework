package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.utils.APIManager;

import io.cucumber.java.en.Given;

public class GetPlaceSteps {

	private final ScenarioContext scenarioContext;
	private final APIManager apiManager; // This gets injected by PicoContainer at runtime.

	public GetPlaceSteps(ScenarioContext scenarioContext, APIManager apiManager) {
		this.scenarioContext = scenarioContext;
		this.apiManager = apiManager;
	}

	@Given("Get Place Payload with a place id")
	public void getPlace() {
		scenarioContext.setReq(apiManager.getRequestSpec().queryParam("place_id", scenarioContext.getPlaceId())
				.header("Content-Type", "application/json"));
	}

	@Given("Get Place Payload with a place id {string}")
	public void getPlaceWithId(String placeId) {
		scenarioContext.setReq(apiManager.getRequestSpec().queryParam("place_id", placeId)
				.header("Content-Type", "application/json"));
	}

}
