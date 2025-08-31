// CommonSteps.java
package com.darkuros.restassured.stepdefinitions.common;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.darkuros.restassured.stepdefinitions.other.ScenarioContext;
import com.darkuros.restassured.utils.APIManager;
import com.darkuros.restassured.utils.APIResources;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;

public class CommonSteps {

	private final ScenarioContext scenarioContext;
	private final APIManager apiManager;

	public CommonSteps(ScenarioContext scenarioContext, APIManager apiManager) {
		this.scenarioContext = scenarioContext;
		this.apiManager = apiManager;
	}

	@When("user calls {string} with {string} http request")
	public void userCallsAPI(String resource, String method) {
		APIResources resourceAPI = APIResources.valueOf(resource);
		RequestSpecification requestSpec = scenarioContext.getReq();

		switch (method.toUpperCase()) {
		case "POST":
			scenarioContext.setRes(given(requestSpec).when().post(resourceAPI.getResource()));
			break;
		case "GET":
			scenarioContext.setRes(given(requestSpec).when().get(resourceAPI.getResource()));
			break;
		case "PUT":
			scenarioContext.setRes(given(requestSpec).when().put(resourceAPI.getResource()));
			break;
		case "DELETE":
			scenarioContext.setRes(given(requestSpec).when().delete(resourceAPI.getResource()));
			break;
		case "PATCH":
			scenarioContext.setRes(given(requestSpec).when().patch(resourceAPI.getResource()));
			break;
		default:
			throw new IllegalArgumentException("Unsupported HTTP method: " + method);
		}
	}

	@Then("the API call is successful with status code {int}")
	public void validateStatusCode(int code) {
		scenarioContext.getRes().then().spec(apiManager.getResponseSpec(code));
	}

	@Then("{string} in response body is {string}")
	public void validateFieldInResponse(String key, String expectedValue) {
		scenarioContext.getRes().then().body(key, equalTo(expectedValue));
	}
}