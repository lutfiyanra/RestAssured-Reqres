Feature: Delete User

  @latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with id <id>
    When Send delete user request
    Then Status code should be 204 No Content
    Examples:
      |id|
      |2 |

  @tugas
  Scenario Outline: Delete user with invalid id above expected value
    Given Delete user with invalid id <id>
    When Send delete user request
    Then Should return 404 not found
    Examples:
      | id    |
      | 99    |
      | 134   |

  @tugas
  Scenario Outline: Delete user with invalid id by character
    Given Delete user with invalid id by character "<id>"
    When Send delete user request
    Then Should return 404 not found
    Examples:
    | id  |
    | qwe |
    | kjh |

  @tugas
  Scenario Outline: Delete user with invalid id by special character
    Given Delete user with invalid id by special character "<id>"
    When Send delete user request
    Then Should return 404 not found
    Examples:
    | id    |
    | !@#$  |
    | %^&*  |

  @tugas
  Scenario Outline: Delete user with invalid path by character
    Given Delete user with invalid path by character "<path>"
    When Send delete user with invalid path
    Then Should return 404 not found
    Examples:
    | path    |
    | sdkf    |
    | userr/2 |

  @tugas
  Scenario Outline: Delete user with invalid path by special character
    Given Delete user with invalid path by special character "<path>"
    When Send delete user with invalid path
    Then Should return 404 not found
    Examples:
    | path  |
    | $%^&  |
    | @#*)( |

