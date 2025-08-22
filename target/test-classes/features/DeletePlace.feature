@DeletePlace
Feature: Delete Place API

  Scenario: Successfully delete an existing place
    Given Delete Place Payload with place_id "1094d09e807739d3f749d07689e441f4" from file "deletePlace.json"
    When user calls "DELETE_PLACE" with "DELETE" http request
    Then the API call is successful with status code 200
    And "status" in response body is "OK"