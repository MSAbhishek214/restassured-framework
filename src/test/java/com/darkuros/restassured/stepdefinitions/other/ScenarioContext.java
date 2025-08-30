package com.darkuros.restassured.stepdefinitions.other;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// This class is used to hold common steps and shared variables for the step definitions
public class ScenarioContext {

	private RequestSpecification req; // Request specification for API calls
	private Response res; // Response object to hold API responses
	private String placeId; // Variable to store place ID
	private Scenario scenario; // Scenario object to hold the current scenario

	public ScenarioContext() {
		// Default constructor for dependency injection
	}

	// Getters and Setters for RequestSpecification and Response
	public RequestSpecification getReq() {
		return req;
	}

	public void setReq(RequestSpecification req) {
		this.req = req;
	}

	public Response getRes() {
		return res;
	}

	public void setRes(Response res) {
		this.res = res;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

}
