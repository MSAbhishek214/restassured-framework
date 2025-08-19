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
	public Hooks(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
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
		scenario.log("Scenario completed: " + scenario.getName());
		
		try {
            Files.lines(Paths.get(APIManager.getLogFileName())).forEach(line -> scenario.log(line));
        } catch (IOException e) {
            scenario.log("Could not attach logs. Error: " + e.getMessage());
        }

		/*
		 * // The logic to attach console logs to the report byte[] consoleLogs = null;
		 * try { consoleLogs = Files.readAllBytes(new
		 * File(APIManager.getLogFileName()).toPath()); } catch (IOException e) {
		 * e.printStackTrace(); } // Only attach logs if they are not null if
		 * (consoleLogs != null) { scenario.attach(consoleLogs, "text/plain",
		 * "Console Logs"); }
		 * This method doesnt attached the console logs to the report properly
		 * I am gonna print each line from log to the report directly
		 * instead of attaching the whole file.
		 */
	}
}
