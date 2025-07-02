Feature: End To End Swag Labs
@Endtoend
  Scenario: End to End
    Given user Login app swag lab
    And user see the product page
    When user click product Sauce Labs Backpack ADD TO CART
    And user click product Sauce Labs Bike Light ADD TO CART
    And  user Verify Icon cart appears 2
    And user click Icon cart
    And user click CHECKOUT
    And user fill First Name
    And user fill Last Name
    And user fill Zip Code
    And  user click CONTINUE
    And user click Finish
    Then user verify wording  Checkout : Complete!
