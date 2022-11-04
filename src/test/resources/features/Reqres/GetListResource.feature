Feature: Get list resource
  @tugas
  Scenario: Get list resource with valid path
    Given Get list resource with valid  path "unknown"
    When Send request to get list resource
    Then Should return 200 OK
    And Response body page should be page 1 and total pages are 2
    And Validate get list resource json schema

  @tugas
  Scenario Outline: Get list resource with invalid path
    Given Get list resource with invalid path "<path>"
    When Send request to get list resource
    Then Should return 404 not found
    Examples:
    | path  |
    | !@#$% |
    | abcde |
    | 12345 |

  @tugas
  Scenario: Get list resource with valid page parameter
    Given Get list resource with valid page parameter 2
    When Send request to get list resource with valid page parameter
    Then Should return 200 OK
    And Response body page should contain page 2
    And Validate get list resource json schema