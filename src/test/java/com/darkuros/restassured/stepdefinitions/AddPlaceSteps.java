package com.darkuros.restassured.stepdefinitions;

import static com.darkuros.restassured.utils.FrameworkConstants.API_KEY_NAME;
import static com.darkuros.restassured.utils.FrameworkConstants.API_KEY_VALUE;
import static com.darkuros.restassured.utils.FrameworkConstants.BASE_URL;

import java.util.List;

import com.darkuros.restassured.model.AddPlace;
import com.darkuros.restassured.model.Location;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;

public class AddPlaceSteps {

	private final CommonSteps commonSteps;

	public AddPlaceSteps(CommonSteps commonSteps) {
		// Initialize the request specification and response
		this.commonSteps = commonSteps;
	}

	@Given("Add Place Payload with name {string}, language {string}, and address {string}")
	public void addPlacePayload(String name, String language, String address) {
		// Build location object with latitude and longitude
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);

		// Build the AddPlace object
		AddPlace addPlace = new AddPlace();
		addPlace.setLocation(location);
		addPlace.setAccuracy(50);
		addPlace.setName(name);
		addPlace.setPhoneNumber("(+91) 983 893 3937");
		addPlace.setAddress(address);
		addPlace.setTypes(List.of("shoe park", "shop"));
		addPlace.setWebsite("http://google.com");
		addPlace.setLanguage(language);

		// Base URI for the API
		RestAssured.baseURI = BASE_URL;
		// Create a request specification with query parameters and headers
		commonSteps.setReq(RestAssured.given().log().ifValidationFails().queryParam(API_KEY_NAME, API_KEY_VALUE)
				.header("Content-Type", "application/json").body(addPlace).log().body());
	}

	@Then("store place_id from response")
	public void storePlaceId() {
		commonSteps.setPlaceId(commonSteps.getRes().jsonPath().getString("place_id"));
	}
}
