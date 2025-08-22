@AddPlace
Feature: Add Place API

  Scenario: Successfully add a new place
    Given Add Place Payload from file "addPlace.json"
    When user calls "ADD_PLACE" with "POST" http request
    Then the API call is successful with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And store place_id from response