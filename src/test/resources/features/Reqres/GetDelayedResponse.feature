Feature: Get Delayed Response

  @tugas
  Scenario: Get delayed response with valid parameter value
    Given Get delayed response with valid parameter delay 3
    When Send request to get delayed response
    Then Should return 200 OK
    And Validate get delayed response json schema