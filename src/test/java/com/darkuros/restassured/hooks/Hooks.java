package com.darkuros.restassured.hooks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.darkuros.restassured.stepdefinitions.ScenarioContext;
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
	 * This method is executed before all scenarios in the test suite.
	 */
	@BeforeAll
	public static void initialize() {
		ConfigReader.initialize();
	}

	/**
	 * This method gets the scenario object from ScenarioContext.
	 */
	public Hooks(ScenarioContext scenarioContext, APIManager apiManager) {
		this.scenarioContext = scenarioContext;
		this.apiManager = apiManager;
	}

	/**
	 * This method is executed before each scenario.
	 */
	@Before
	public void setUp(Scenario scenario) {
		scenarioContext.setScenario(scenario);
	}

	/**
	 * This method is executed after each scenario.
	 */
	@After
	public void tearDown(Scenario scenario) {
		
		try {
			Files.lines(Paths.get(apiManager.getLogFileName())).forEach(line -> scenario.log(line));
		} catch (IOException e) {
			scenario.log("Could not attach logs. Error: " + e.getMessage());
		}
	}
}
