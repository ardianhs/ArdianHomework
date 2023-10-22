Feature: Checkout Product

  @checkout
  Scenario Outline: Checkout Product
    Given the user is on web login page
    And the user has entered <username> as username
    And the user has entered <password> as password
    And the user click login button
    And the user verify <status> login result
    And the user click addtochart
    And the user success adding product
    And the user click icon cart
    When the user on the cart page
    And the user click checkout button on cartpage
    When the user on information page
    And the user fill information
    And the user click continue button on information page
    When the user on checkout overview page
    And the user click finish on overview page
    Then the user success checkout

    Examples:
      |username        | password       |status   |
      |standard_user   | secret_sauce   |success  |