@GetPlace
Feature: Get Place by ID API
	
	Scenario: Successfully get a place by id
	Given Get Place Payload with a place id "1094d09e807739d3f749d07689e441f4"
	When user calls "GET_PLACE" with "GET" http request
	Then the API call is successful with status code 200
	And "address" in response body is "Bengaluru South"