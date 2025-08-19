// CommonAPISteps.java
package com.darkuros.restassured.stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.darkuros.restassured.utils.APIResources;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;

public class CommonAPISteps {

	private final ScenarioContext scenarioContext;

	public CommonAPISteps(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
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
		scenarioContext.getRes().then().statusCode(code);
	}

	@Then("{string} in response body is {string}")
	public void validateFieldInResponse(String key, String expectedValue) {
		scenarioContext.getRes().then().body(key, equalTo(expectedValue));
	}
}