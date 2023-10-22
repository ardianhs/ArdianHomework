Feature: Add Product

  @add
  Scenario Outline: Add Product
    Given the user is on web login page
    And the user has entered <username> as username
    And the user has entered <password> as password
    And the user click login button
    And the user verify <status> login result
    When the user click addtochart
    Then the user success adding product

    Examples:
      |username        | password       |status   |
      |standard_user   | secret_sauce   |success  |