package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.utils.ConfigReader;

import com.darkuros.restassured.payloadfactory.PayloadFactory;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class UpdatePlaceSteps {

	private final CommonSteps commonSteps;

	public UpdatePlaceSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

	@Given("Update Place Payload with new address {string}")
	public void updatePlace(String newAddress) {
		RestAssured.baseURI = ConfigReader.getProperty("base.url");
		commonSteps.setReq(RestAssured.given().log().ifValidationFails()
				.queryParam(ConfigReader.getProperty("api.key.name"), ConfigReader.getProperty("api.key.value"))
				.queryParam("place_id", commonSteps.getPlaceId()).header("Content-Type", "application/json")
				.body(PayloadFactory.updatePlacePayload(commonSteps.getPlaceId(), newAddress,
						ConfigReader.getProperty("api.key.value"))));
	}

}
