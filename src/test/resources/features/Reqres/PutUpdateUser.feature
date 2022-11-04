Feature: Put Update User
  @latihan
  Scenario Outline: Put update user with valid json
    Given Put update user with valid json with id <id>
    When Send put update user request
    Then Status code should be 200 OK
    And Response body should contain name "Riza Update" and job "QA Engineer Update"
    And Validate update user json schema
    Examples:
      |id |
      |1  |
      |2  |

  @tugas
  Scenario Outline: Put update user with empty job
    Given Put update user with id <id> only input name
    When Send put update user request
    Then Should return 400 bad request
    Examples:
    | id  |
    |  1  |
    |  2  |

  @tugas
  Scenario Outline: Put update user with empty name
    Given Put update user with id <id> only input job
    When Send put update user request
    Then Should return 400 bad request
    Examples:
    | id  |
    | 1   |
    | 2   |

  @tugas
  Scenario Outline: Put update user without input any body json
    Given Put update user with id <id> empty name and empty job
    When Send put update user request
    Then Should return 400 bad request
    Examples:
    | id  |
    | 1   |
    | 2   |

  @tugas
  Scenario Outline: Put update user with invalid path by character and valid json
    Given Put update user with invalid path "<path>" by character and valid json
    When Send put update user request invalid path
    Then Should return 404 not found
    Examples:
    | path  |
    | asdwq |
    | sdskk |

  @tugas
  Scenario Outline: Put update user with invalid path by special character and valid json
    Given Put update user with invalid path "<path>" by special character and valid json
    When Send put update user request invalid path
    Then Should return 404 not found
    Examples:
    | path  |
    | !@&%( |
    | )^#*$ |