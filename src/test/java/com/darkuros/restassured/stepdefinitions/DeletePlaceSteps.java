package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.payloadfactory.PayloadFactory;
import com.darkuros.restassured.utils.APIManager;
import com.darkuros.restassured.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class DeletePlaceSteps {

	private final ScenarioContext scenarioContext;

	public DeletePlaceSteps(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
	}

	@Given("Delete Place Payload")
	public void deletePlacePayload() {
		RestAssured.baseURI = ConfigReader.getProperty("base.url");
		scenarioContext.setReq(APIManager.getRequestSpec()
				.body(PayloadFactory.deletePlacePayload(scenarioContext.getPlaceId())));
	}

}
