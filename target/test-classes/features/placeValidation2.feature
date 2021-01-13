Feature: Validating's Place Validation
   @run3
  Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
    Given Add Place Payload "<name>", "<language>","<address>"
    When User calls "addPlaceApi" with "Post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Verify place_Id created maps to "<name>"  using "getPlaceApi"


    Examples:
    | name   | language  | address            |
    |AAhouse | English   | World cross center |
   # |Mark    | Spanish   | Wood dr            |

     @DeletePlace
     Scenario: Verify if Delete Place functionality is working
       Given DeletePlace  Payload
       When user class "deletePlaceAPI" with "POST" http request
       Then the API call got  success with status code 200
       And "status" in response body is "OK"
