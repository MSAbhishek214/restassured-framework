package com.darkuros.restassured.stepdefinitions;

import com.darkuros.restassured.payloads.PayloadBuilder;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class DeletePlaceSteps {

	private final CommonSteps commonSteps;

	public DeletePlaceSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

	@Given("Delete Place Payload")
	public void deletePlacePayload() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		commonSteps.setReq(RestAssured.given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body(PayloadBuilder.deletePlacePayload(commonSteps.getPlaceId())));
	}

}
