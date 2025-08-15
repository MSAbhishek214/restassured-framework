@PlaceLifeCycle
Feature: End to End Place Life Cycle
	
	Scenario: Successfully create a place, fetch by place id, update it, and delete it
	    Given Add Place Payload with name "Darkuros Cafe", language "English", and address "Bengaluru South"
	    When user calls "/maps/api/place/add/json" with "POST" http request
	    Then the API call is successful with status code 200
	    And "status" in response body is "OK"
	    And "scope" in response body is "APP"
	    And store place_id from response
	    
	    Given Get Place Payload with a place id
		When user calls "/maps/api/place/get/json" with "GET" http request
		Then the API call is successful with status code 200
		And "address" in response body is "Bengaluru South"
		
		Given Update Place Payload with new address "70 Summer walk, USA"
	    When user calls "/maps/api/place/update/json" with "PUT" http request
	    Then the API call is successful with status code 200
	    And "msg" in response body is "Address successfully updated"
	    
	    Given Get Place Payload with a place id
		When user calls "/maps/api/place/get/json" with "GET" http request
		Then the API call is successful with status code 200
		And "address" in response body is "70 Summer walk, USA"
		
		Given Delete Place Payload
	    When user calls "/maps/api/place/delete/json" with "DELETE" http request
	    Then the API call is successful with status code 200
	    And "status" in response body is "OK"

	    Given Get Place Payload with a place id
		When user calls "/maps/api/place/get/json" with "GET" http request
		Then the API call is successful with status code 404
		And "msg" in response body is "Get operation failed, looks like place_id  doesn't exists"