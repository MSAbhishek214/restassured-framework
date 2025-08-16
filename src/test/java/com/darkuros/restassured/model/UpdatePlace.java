package com.darkuros.restassured.model;

import com.darkuros.restassured.utils.FrameworkConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePlace {
	@JsonProperty("place_id")
	private String placeId;
	private String address;
	private final String key = FrameworkConstants.API_KEY_VALUE;

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
		return key; // API key is constant and does not need to be set, only getter is needed for
					// jackson serialization.
	}
}
