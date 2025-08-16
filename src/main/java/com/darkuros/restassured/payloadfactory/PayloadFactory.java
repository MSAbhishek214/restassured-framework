package com.darkuros.restassured.payloadfactory;

import java.util.List;

import com.darkuros.restassured.model.AddPlace;
import com.darkuros.restassured.model.DeletePlace;
import com.darkuros.restassured.model.Location;
import com.darkuros.restassured.model.UpdatePlace;

public class PayloadFactory {

	private PayloadFactory() {
		// Private constructor to prevent instantiation
	}

	public static AddPlace createPlacePayload(String name, String address, String language) {
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);

		AddPlace addPlace = new AddPlace();
		addPlace.setLocation(location);
		addPlace.setAccuracy(50);
		addPlace.setName(name);
		addPlace.setPhoneNumber("(+91) 983 893 3937");
		addPlace.setAddress(address);
		addPlace.setTypes(List.of("shoe park", "shop"));
		addPlace.setWebsite("http://google.com");
		addPlace.setLanguage(language);

		return addPlace;
	}

	public static UpdatePlace updatePlacePayload(String placeId, String newAddress) {
		UpdatePlace updatePlace = new UpdatePlace();
		updatePlace.setPlaceId(placeId);
		updatePlace.setAddress(newAddress);
		return updatePlace;

	}

	public static DeletePlace deletePlacePayload(String placeId) {
		DeletePlace deletePlace = new DeletePlace();
		deletePlace.setPlaceId(placeId);
		return deletePlace;
	}
}
