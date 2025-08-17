package com.darkuros.restassured.hooks;

import com.darkuros.restassured.utils.ConfigReader;

import io.cucumber.java.BeforeAll;

public class Hooks {
	/**
	 * This method is executed before all scenarios in the test suite.
	 */
	@BeforeAll
    public static void initialize() {
        ConfigReader.initialize();
    }
}
