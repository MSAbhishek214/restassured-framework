package com.darkuros.restassured.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeletePlace {
	@JsonProperty("place_id")
	private String placeId;

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

}
