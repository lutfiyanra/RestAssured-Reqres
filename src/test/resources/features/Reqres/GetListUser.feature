Feature: Get list user
  @latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with parameter page <page>
    When Send get list user request
    Then Should return 200 OK
    And Respons body page should be <page>
    And Validate get list user json schema
    Examples:
    |page|
    |1   |
    |2   |

  @tugas
  Scenario Outline: Get list user with invalid parameter page with character & special character
    Given Get list user with invalid parameter page "<page>"
    When Send get list user request
    Then Should return 404 not found
    Examples:
    |page   |
    |^*&$#  |
    |abcd   |