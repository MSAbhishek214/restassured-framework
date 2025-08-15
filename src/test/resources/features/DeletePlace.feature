@DeletePlace
Feature: Delete Place API

  Scenario: Successfully delete an existing place
    Given Delete Place Payload
    When user calls "/maps/api/place/delete/json" with "DELETE" http request
    Then the API call is successful with status code 200
    And "status" in response body is "OK"