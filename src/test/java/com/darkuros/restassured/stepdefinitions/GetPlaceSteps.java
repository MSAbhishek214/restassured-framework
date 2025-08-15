package com.darkuros.restassured.stepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class GetPlaceSteps {

	private final CommonSteps commonSteps;

	public GetPlaceSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

	@Given("Get Place Payload with a place id")
	public void getPlace() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		commonSteps.setReq(RestAssured.given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", commonSteps.getPlaceId()).header("Content-Type", "application/json"));
	}

}
