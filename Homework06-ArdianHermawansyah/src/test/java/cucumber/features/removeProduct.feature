Feature: Remove Product

  @remove
  Scenario Outline: Remove Product
    Given the user is on web login page
    And the user has entered <username> as username
    And the user has entered <password> as password
    And the user click login button
    And the user verify <status> login result
    And the user click addtochart
    And the user success adding product
    When the user click remove
    Then the user success remove product

    Examples:
      |username        | password       |status   |
      |standard_user   | secret_sauce   |success  |