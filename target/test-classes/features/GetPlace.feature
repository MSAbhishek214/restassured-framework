@GetPlace
Feature: Get Place by ID API
	
	Scenario: Successfully get a place by id
	Given Get Place Payload with a place id
	When user calls "GET_PLACE" with "GET" http request
	Then the API call is successful with status code 200
	And "address" in response body is "Bengaluru South"