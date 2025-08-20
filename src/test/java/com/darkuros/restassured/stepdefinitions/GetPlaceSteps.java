package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.utils.APIManager;
import com.darkuros.restassured.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class GetPlaceSteps {

	private final ScenarioContext scenarioContext;
	private final APIManager apiManager; // This gets injected by PicoContainer at runtime.

	public GetPlaceSteps(ScenarioContext scenarioContext, APIManager apiManager) {
		this.scenarioContext = scenarioContext;
		this.apiManager = apiManager;
	}

	@Given("Get Place Payload with a place id")
	public void getPlace() {
		RestAssured.baseURI = ConfigReader.getProperty("base.url");
		scenarioContext.setReq(apiManager.getRequestSpec().queryParam("place_id", scenarioContext.getPlaceId())
				.header("Content-Type", "application/json"));
	}

}
