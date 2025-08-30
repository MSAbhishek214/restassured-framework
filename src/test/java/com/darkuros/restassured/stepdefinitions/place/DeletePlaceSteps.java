package com.darkuros.restassured.stepdefinitions.place;

import com.darkuros.restassured.payloadfactory.PayloadFactory;
import com.darkuros.restassured.stepdefinitions.other.ScenarioContext;
import com.darkuros.restassured.utils.APIManager;
import com.darkuros.restassured.utils.JsonDataReader;
import com.google.gson.JsonObject;

import io.cucumber.java.en.Given;

public class DeletePlaceSteps {

	private final ScenarioContext scenarioContext;
	private final APIManager apiManager; // This gets injected by PicoContainer at runtime.

	public DeletePlaceSteps(ScenarioContext scenarioContext, APIManager apiManager) {
		this.scenarioContext = scenarioContext;
		this.apiManager = apiManager;
	}

	@Given("Delete Place Payload")
	public void deletePlacePayload() {
		scenarioContext.setReq(
				apiManager.getRequestSpec().body(PayloadFactory.deletePlacePayload(scenarioContext.getPlaceId())));
	}
	
	@Given("Delete Place Payload with place_id {string} from file {string}")
	public void deletePlacePayloadWithPlaceId(String placeId, String fileName) {
		JsonObject jsonData = new JsonDataReader().readTestData(fileName);
		scenarioContext.setReq(
				apiManager.getRequestSpec().body(jsonData.toString()));
	}

}


