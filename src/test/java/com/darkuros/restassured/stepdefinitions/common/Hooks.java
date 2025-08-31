package com.darkuros.restassured.stepdefinitions.common;

import com.darkuros.restassured.stepdefinitions.other.ScenarioContext;
import com.darkuros.restassured.utils.APIManager;
import com.darkuros.restassured.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	private final ScenarioContext scenarioContext;
	private final APIManager apiManager; // This gets injected by PicoContainer

	/**
	 * This method is executed before all scenarios in the test suite. It
	 * initializes the configuration reader.
	 */
	@BeforeAll
	public static void initialize() {
		ConfigReader.initialize();
	}

	/**
	 * This method gets the scenario object from ScenarioContext. It also gets the
	 * APIManager instance injected by PicoContainer.
	 */
	public Hooks(ScenarioContext scenarioContext, APIManager apiManager) {
		this.scenarioContext = scenarioContext;
		this.apiManager = apiManager;
	}

	/**
	 * This method is executed before each scenario. It sets the current scenario in
	 * the ScenarioContext.
	 */
	@Before
	public void setUp(Scenario scenario) {
		scenarioContext.setScenario(scenario);
	}

	/**
	 * This method is executed after each scenario. If the scenario has failed, it
	 * retrieves and prints the API logs
	 */
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			System.out.println("--- API Logs for failed test ---");
			// Get logs from the correct APIManager instance for this scenario
			System.out.println(apiManager.getLogs());
			System.out.println("-------------------------------");
		}
	}
}
