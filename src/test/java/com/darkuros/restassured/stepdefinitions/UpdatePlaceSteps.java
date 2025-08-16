package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.payloads.PayloadBuilder;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

import static com.darkuros.restassured.utils.FrameworkConstants.API_KEY_NAME;
import static com.darkuros.restassured.utils.FrameworkConstants.API_KEY_VALUE;
import static com.darkuros.restassured.utils.FrameworkConstants.BASE_URL;

public class UpdatePlaceSteps {

	private final CommonSteps commonSteps;

	public UpdatePlaceSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

	@Given("Update Place Payload with new address {string}")
	public void updatePlace(String newAddress) {
		RestAssured.baseURI = BASE_URL;
		commonSteps.setReq(RestAssured.given().log().ifValidationFails().queryParam(API_KEY_NAME, API_KEY_VALUE)
				.queryParam("place_id", commonSteps.getPlaceId()).header("Content-Type", "application/json")
				.body(PayloadBuilder.updatePlacePayload(commonSteps.getPlaceId(), newAddress)));
	}

}
