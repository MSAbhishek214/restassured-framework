@UpdatePlace
Feature: Update Place API

  Scenario: Successfully update an existing place
    Given Update Place Payload with new address "70 Summer walk, USA"
    When user calls "/maps/api/place/update/json" with "PUT" http request
    Then the API call is successful with status code 200
    And "msg" in response body is "Address successfully updated"