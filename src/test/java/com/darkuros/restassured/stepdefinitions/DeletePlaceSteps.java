package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.payloadfactory.PayloadFactory;
import com.darkuros.restassured.utils.APIManager;
import com.darkuros.restassured.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class DeletePlaceSteps {

	private final ScenarioContext scenarioContext;
	private final APIManager apiManager; // This gets injected by PicoContainer at runtime.

	public DeletePlaceSteps(ScenarioContext scenarioContext, APIManager apiManager) {
		this.scenarioContext = scenarioContext;
		this.apiManager = apiManager;
	}

	@Given("Delete Place Payload")
	public void deletePlacePayload() {
		RestAssured.baseURI = ConfigReader.getProperty("base.url");
		scenarioContext.setReq(
				apiManager.getRequestSpec().body(PayloadFactory.deletePlacePayload(scenarioContext.getPlaceId())));
	}

}
