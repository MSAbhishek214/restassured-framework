package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.payloadfactory.PayloadFactory;
import com.darkuros.restassured.utils.APIManager;
import com.darkuros.restassured.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class UpdatePlaceSteps {

	private final ScenarioContext scenarioContext;

	public UpdatePlaceSteps(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
	}

	@Given("Update Place Payload with new address {string}")
	public void updatePlace(String newAddress) {
		RestAssured.baseURI = ConfigReader.getProperty("base.url");
		scenarioContext.setReq(APIManager.getRequestSpec()
				.queryParam("place_id", scenarioContext.getPlaceId())
				.body(PayloadFactory.updatePlacePayload(scenarioContext.getPlaceId(), newAddress,
						ConfigReader.getProperty("api.key.value"))));
	}

}
