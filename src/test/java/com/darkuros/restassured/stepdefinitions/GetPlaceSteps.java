package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class GetPlaceSteps {

	private final CommonSteps commonSteps;

	public GetPlaceSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

	@Given("Get Place Payload with a place id")
	public void getPlace() {
		RestAssured.baseURI = ConfigReader.getProperty("base.url");
		commonSteps.setReq(RestAssured.given().log().ifValidationFails()
				.queryParam(ConfigReader.getProperty("api.key.name"), ConfigReader.getProperty("api.key.value"))
				.queryParam("place_id", commonSteps.getPlaceId()).header("Content-Type", "application/json"));
	}

}
