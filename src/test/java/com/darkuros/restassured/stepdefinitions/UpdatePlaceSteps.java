package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.payloadfactory.PayloadFactory;
import com.darkuros.restassured.utils.APIManager;
import com.darkuros.restassured.utils.ConfigReader;
import com.darkuros.restassured.utils.JsonDataReader;
import com.google.gson.JsonObject;

import io.cucumber.java.en.Given;

public class UpdatePlaceSteps {

	private final ScenarioContext scenarioContext;
	private final APIManager apiManager; // This gets injected by PicoContainer at runtime.

	public UpdatePlaceSteps(ScenarioContext scenarioContext, APIManager apiManager) {
		this.scenarioContext = scenarioContext;
		this.apiManager = apiManager;
	}

	@Given("Update Place Payload with new address {string}")
	public void updatePlace(String newAddress) {
		scenarioContext.setReq(apiManager.getRequestSpec().queryParam("place_id", scenarioContext.getPlaceId())
				.body(PayloadFactory.updatePlacePayload(scenarioContext.getPlaceId(), newAddress,
						ConfigReader.getProperty("api.key.value"))));
	}

	@Given("Update Place Payload with new address {string} and place_id {string} from file {string}")
	public void updatePlaceWithId(String newAddress, String placeId, String filename) {
		JsonObject jsonData = new JsonDataReader().readTestData(filename);
		scenarioContext.setReq(apiManager.getRequestSpec().queryParam("place_id", placeId).body(jsonData.toString()));
	}

}
