package com.darkuros.restassured.stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

import static com.darkuros.restassured.utils.FrameworkConstants.API_KEY_NAME;
import static com.darkuros.restassured.utils.FrameworkConstants.API_KEY_VALUE;
import static com.darkuros.restassured.utils.FrameworkConstants.BASE_URL;

public class GetPlaceSteps {

	private final CommonSteps commonSteps;

	public GetPlaceSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

	@Given("Get Place Payload with a place id")
	public void getPlace() {
		RestAssured.baseURI = BASE_URL;
		commonSteps.setReq(RestAssured.given().log().ifValidationFails().queryParam(API_KEY_NAME, API_KEY_VALUE)
				.queryParam("place_id", commonSteps.getPlaceId()).header("Content-Type", "application/json"));
	}

}
