package com.darkuros.restassured.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigReader {
	private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";
	private static Properties properties;

	// Private constructor to prevent instantiation
	private ConfigReader() {
	}

	/**
	 * Initializes the properties object by loading the config.properties file. This
	 * method should be called once, before any tests are run.
	 */
	public static void initialize() {
		if (properties == null) {
			properties = new Properties();
			try (FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH)) {
				properties.load(fileInputStream);
			} catch (IOException e) {
				// You can add more robust logging here if needed
				throw new RuntimeException("Error loading configuration file: " + CONFIG_FILE_PATH, e);
			}
		}
	}

	/**
	 * Returns the value for a given key from the configuration file.
	 * 
	 * @param key The key to look up in the properties file.
	 * @return The value associated with the key.
	 */
	public static String getProperty(String key) {
		if (properties == null) {
			throw new IllegalStateException("ConfigReader has not been initialized. Call initialize() first.");
		}
		return properties.getProperty(key);
	}
}