Feature: Post Login
  @tugas
  Scenario: Post login with valid value
    Given Post login with all valid value
    When Send request post login
    Then Should return 200 OK
    And Response body should contain token "QpwL5tke4Pnpja7X4"
    And Validate post login valid value json schema

  @tugas
  Scenario: Post login without input password
    Given Post login input email empty password
    When Send request post login
    Then Should return 400 bad request
    And Response body should contain error message "Missing Password"
    And Validate post login error message json schema

  @tugas
  Scenario: Post login without input email
    Given Post login input password empty email
    When Send request post login
    Then Should return 400 bad request
    And Response body should contain error message "Missing email"
    And Validate post login error message json schema

  @tugas
  Scenario: Post login with empty value
    Given Post login empty email empty password
    When Send request post login
    Then Should return 400 bad request
    And Response body should contain error message "Missing email and password"
    And Validate post login error message json schema

  @tugas
  Scenario: Post login with unregistered email
    Given Post login input with unregistered email
    When Send request post login
    Then Should return 400 bad request
    And Response body should contain error message "Email not found"
    And Validate post login error message json schema