package com.darkuros.restassured.stepdefinitions;

import static com.darkuros.restassured.utils.FrameworkConstants.API_KEY_NAME;
import static com.darkuros.restassured.utils.FrameworkConstants.API_KEY_VALUE;
import static com.darkuros.restassured.utils.FrameworkConstants.BASE_URL;

import com.darkuros.restassured.model.DeletePlace;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class DeletePlaceSteps {

	private final CommonSteps commonSteps;

	public DeletePlaceSteps(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

	@Given("Delete Place Payload")
	public void deletePlacePayload() {
		// Create a payload for deleting a place
		DeletePlace deletePlace = new DeletePlace();
		deletePlace.setPlaceId(commonSteps.getPlaceId());
		RestAssured.baseURI = BASE_URL;
		commonSteps.setReq(RestAssured.given().log().ifValidationFails().queryParam(API_KEY_NAME, API_KEY_VALUE)
				.header("Content-Type", "application/json").body(deletePlace));
	}

}
