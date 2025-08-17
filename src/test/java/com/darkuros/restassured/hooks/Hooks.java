package com.darkuros.restassured.hooks;

import com.darkuros.restassured.utils.ConfigReader;

import io.cucumber.java.BeforeAll;

public class Hooks {
	/**
	 * This method is executed before all scenarios in the test suite.
	 */
	@BeforeAll
    public static void initialize() {
        System.out.println("Initializing ConfigReader...");
        ConfigReader.initialize();
        System.out.println("ConfigReader initialized successfully.");
    }
}
