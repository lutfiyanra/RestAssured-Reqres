Feature: Get single resource

  @tugas
  Scenario: Get single resource with valid id
    Given Get single resource with id 2
    When Send request to get single resource
    Then Should return 200 OK
    And Response body page should be id is 2 and name is "fuchsia rose" and year 2001 and color is "#C74375" and pantone_value is "17-2031"
    And Validate get single resource json schema

  @tugas
  Scenario Outline: Get single resource invalid id with id higher than actual value
    Given Get single resource with id <id>
    When Send request to get single resource
    Then Should return 404 not found
    Examples:
    | id  |
    | 123 |

  @tugas
  Scenario Outline: Get single resource invalid id with value string
    Given Get single resource with id "<id>"
    When Send request to get single resource
    Then Should return 404 not found
    Examples:
    | id    |
    | asdkj |
