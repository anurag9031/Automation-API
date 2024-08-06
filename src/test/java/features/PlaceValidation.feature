Feature: Validating Place API's
@AddPlaceAPI @Regression
  Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
    Given Add place payload "<name>","<language>","<address>"
    When user call "AddPlaceAPI" with "Post" http request
    Then the api call got success with status code 200
    And "status" in response body  is "OK"
    And "scope" in response body  is "APP"
    And Verify Place id created maps to "<name>" using "GetPlaceAPI"

    Examples:
              |name    |language    |address           |
              |ABCHOUSE|Spanish     |World Cross Centre|
              |DEFHOUSE|English     |Dev Cross Centre  |
              |NewHOME |Danish      |Zero Cross Centre |


@DeletePlaceAPI @Regression
  Scenario: Verify DELETE is being successfully using DeletePlaceAPI
      Given Delete place payload with DeletePlaceAPI
      When user call "DeletePlaceAPI" with "Post" http request
      Then the api call got success with status code 200
      And "status" in response body  is "OK"

