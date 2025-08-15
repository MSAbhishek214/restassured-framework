package com.darkuros.restassured.payloads;

public class PayloadBuilder {

	public static String addPlacePayload(String name, String language, String address) {
		return "{\n" + "  \"location\": {\n" + "    \"lat\": -38.383494,\n" + "    \"lng\": 33.427362\n" + "  },\n"
				+ "  \"accuracy\": 50,\n" + "  \"name\": \"" + name + "\",\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\n" + "  \"address\": \"" + address + "\",\n"
				+ "  \"types\": [\"cafe\"],\n" + "  \"website\": \"http://darkuros.com\",\n" + "  \"language\": \""
				+ language + "\"\n" + "}";
	}

	public static String updatePlacePayload(String placeId, String newAddress) {
		return "{\n" + "  \"place_id\":\"" + placeId + "\",\n" + "  \"address\":\"" + newAddress + "\",\n"
				+ "  \"key\":\"qaclick123\"\n" + "}";

	}
	
	public static String deletePlacePayload(String placeId) {
		return "{\n" + "  \"place_id\": \"" + placeId + "\"\n" + "}";
	}
}
