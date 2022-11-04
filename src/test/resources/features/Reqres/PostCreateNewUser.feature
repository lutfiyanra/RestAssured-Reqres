Feature: Post Create New User
  @latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send post create user request
    Then Status code should be 201 Created
    And Response body should contain name "Riza" and job "QA Engineer"
    And Validate create user json schema

  @tugas
  Scenario: Post create new user with empty job
    Given Post create new user input name empty job
    When Send post create user request
    Then Should return 400 bad request

  @tugas
  Scenario: Post create new user with empty name
    Given Post create new user input job empty name
    When Send post create user request
    Then Should return 400 bad request

  @tugas
  Scenario: Post create new user with empty name and empty job
    Given Post create new user with empty name and empty job
    When Send post create user request
    Then Should return 400 bad request