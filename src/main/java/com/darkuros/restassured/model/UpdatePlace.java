package com.darkuros.restassured.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePlace {
	@JsonProperty("place_id")
	private String placeId;
	private String address;
	private String key;

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
}
