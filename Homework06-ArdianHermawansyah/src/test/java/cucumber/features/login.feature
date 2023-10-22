Feature: Login Saucedemo

  @TDD
  Scenario Outline: Login to saucedemo
    Given the user is on web login page
    And the user has entered <username> as username
    And the user has entered <password> as password
    When the user click login button
    Then the user verify <status> login result

    Examples:
    |username        | password       |status   |
    |standard_user   | secret_sauce   |success  |
    |ardian          | ardian         |failed   |




