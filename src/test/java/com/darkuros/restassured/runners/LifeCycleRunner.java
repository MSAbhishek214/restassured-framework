package com.darkuros.restassured.runners;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.SNIPPET_TYPE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasspathResource("features/PlaceLifeCycle.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.darkuros.restassured.stepdefinitions, com.darkuros.restassured.hooks")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports.html, json:target/cucumber-reports.json, com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase")
public class LifeCycleRunner {
}