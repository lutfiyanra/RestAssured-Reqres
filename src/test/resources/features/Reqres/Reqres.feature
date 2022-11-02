Feature: Reqres Feature test
  @latihan
  Scenario Outline: Get list user with valid parameter pages
    Given Get list user with parameter page <page>
    When Send get list user request
    Then Status code should be 200 OK
    And Respons body page should be <page>
    Examples:
      |page  |
      |1     |
      |2     |
    @latihan
    Scenario: Post create new user with valid json
      Given Post create user with valid json
      When Send post create user request
      Then Status code should be 201 Created
      And Response body should contain name "Riza" and job "QA Engineer"
      @latihan
    Scenario Outline: Put update user with valid json
        Given Put update user with valid json with id <id>
        When Send put update user request
        Then Status code should be 200 OK
        And Response body should contain name "Riza Update" and job "QA Engineer Update"
      Examples:
        |id |
        |1  |
        |2  |
      @latihan
      Scenario Outline: Delete user with valid id
        Given Delete user with id <id>
        When Send delete user request
        Then Status code should be 204 No Content
      Examples:
        |id|
        |2 |




