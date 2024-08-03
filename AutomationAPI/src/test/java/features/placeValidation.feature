Feature: Validating Place API's

  Scenario: Verify if Place is being successfully added using AddPlaceAPI
    Given Add place payload
    When User call "AddPlaceAPI" with Post http request
    Then the api call got success with status code 200
    And "status" in response body  is "OK"
    And "scope" in response body  is "APP"