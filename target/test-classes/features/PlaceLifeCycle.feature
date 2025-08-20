@PlaceLifeCycle
Feature: End to End Place Life Cycle
	
	Scenario Outline: Successfully create and validate different places
	    Given Add Place Payload with name "<name>", language "<language>", and address "<address>"
        When user calls "ADD_PLACE" with "POST" http request
        Then the API call is successful with status code 200
	    When user calls "ADD_PLACE" with "POST" http request
	    Then the API call is successful with status code 200
	    And "status" in response body is "OK"
	    And "scope" in response body is "APP"
	    And store place_id from response
	    
	    Given Get Place Payload with a place id
		When user calls "GET_PLACE" with "GET" http request
		Then the API call is successful with status code 200
		And "address" in response body is "Bengaluru South"
		
		Given Update Place Payload with new address "70 Summer walk, USA"
	    When user calls "UPDATE_PLACE" with "PUT" http request
	    Then the API call is successful with status code 200
	    And "msg" in response body is "Address successfully updated"
	    
	    Given Get Place Payload with a place id
		When user calls "GET_PLACE" with "GET" http request
		Then the API call is successful with status code 200
		And "address" in response body is "70 Summer walk, USA"
		
		Given Delete Place Payload
	    When user calls "DELETE_PLACE" with "DELETE" http request
	    Then the API call is successful with status code 200
	    And "status" in response body is "OK"

	    Given Get Place Payload with a place id
		When user calls "GET_PLACE" with "GET" http request
		Then the API call is successful with status code 404
		And "msg" in response body is "Get operation failed, looks like place_id  doesn't exists"
		
		Examples:
	        | name            	| language | address            	|
            | Darkuros Cafe   	| English  | Bengaluru South    	|
            | Darkuros Cafe   	| French   | Bengaluru South    	|
            | Darkuros Cafe   	| Spanish  | Bengaluru South    	|
            | Darkuros Cafe   	| German   | Bengaluru South    	|