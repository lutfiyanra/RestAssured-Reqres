Feature: Post Register

  @tugas
  Scenario: Post register with valid body request
    Given Post register with all valid body request
    When Send request post register
    Then Should return 200 OK
    And Response body should contain id is 4 and token is "QpwL5tke4Pnpja7X4"
    And Validate post register with valid value json schema

  @tugas
  Scenario: Post register without password
    Given Post register input email with empty password
    When Send request post register
    Then Should return 400 bad request
    And Response body should contain error message "Missing Password"
    And Validate post register error message with json schema

  @tugas
  Scenario: Post register without email
    Given Post register input password with empty email
    When Send request post register
    Then Should return 400 bad request
    And Response body should contain error message "Missing email"
    And Validate post register error message with json schema

  @tugas
  Scenario: Post register with empty email and empty password
    Given Post register empty email and empty password
    When Send request post register
    Then Should return 400 bad request
    And Response body should contain error message "Missing email and password"
    And Validate post register error message with json schema
