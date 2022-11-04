Feature: Get single user

  @tugas
  Scenario: Get single user with valid id
    Given Get single user with id 2
    When Send request to get single user
    Then Should return 200 OK
    And Response body should contain id 2 with first name "Janet" and last name "Weaver"
    And Validate get single user with json schema validator

  @tugas
  Scenario Outline: Get single user invalid id with special character
    Given Get single user with invalid id "<id>"
    When Send request to get single user
    Then Should return 404 not found
    Examples:
    | id    |
    | @#!$%^|

  @tugas
  Scenario Outline: Get single user invalid id with character
    Given Get single user with invalid id "<id>"
    When Send request to get single user
    Then Should return 404 not found
    Examples:
    | id    |
    | abcde |

  @tugas
  Scenario Outline: Get single user invalid id with special character and character
    Given Get single user with invalid id "<id>"
    When Send request to get single user
    Then Should return 404 not found
    Examples:
    | id      |
    | abc!@#  |

  @tugas
  Scenario Outline: Get single user invalid id with higher than expected value
    Given Get single user invalid id higher than expected value <id>
    When Send request to get single user
    Then Should return 404 not found
    Examples:
    | id    |
    | 2300  |