package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.payloadfactory.PayloadFactory;
import com.darkuros.restassured.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class DeletePlaceSteps {

	private final CommonSteps commonSteps;

	public DeletePlaceSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

	@Given("Delete Place Payload")
	public void deletePlacePayload() {
		RestAssured.baseURI = ConfigReader.getProperty("base.url");
		commonSteps.setReq(RestAssured.given().log().ifValidationFails()
				.queryParam(ConfigReader.getProperty("api.key.name"), ConfigReader.getProperty("api.key.value"))
				.header("Content-Type", "application/json")
				.body(PayloadFactory.deletePlacePayload(commonSteps.getPlaceId())));
	}

}
