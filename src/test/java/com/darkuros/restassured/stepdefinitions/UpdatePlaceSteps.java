package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.payloads.PayloadBuilder;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class UpdatePlaceSteps {

	private final CommonSteps commonSteps;

	public UpdatePlaceSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

	@Given("Update Place Payload with new address {string}")
	public void updatePlace(String newAddress) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		commonSteps.setReq(RestAssured.given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", commonSteps.getPlaceId()).header("Content-Type", "application/json")
				.body(PayloadBuilder.updatePlacePayload(commonSteps.getPlaceId(), newAddress)));
	}

}
