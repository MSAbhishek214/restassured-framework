package com.darkuros.restassured.utils;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JsonDataReader {
	private static final String JSON_DATA_DIR = "src/test/resources/testdata/";
	private final Gson gson = new Gson();

	public JsonObject readTestData(String filename) {
		String filePath = JSON_DATA_DIR + filename;
		try (FileReader reader = new FileReader(filePath)) {
			return gson.fromJson(reader, JsonObject.class);
		} catch (IOException e) {
			throw new RuntimeException("Failed to read JSON data from file: " + filePath, e);
		}
	}
}
