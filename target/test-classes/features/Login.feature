Feature: Login to Sample App

  Scenario: Successful Login
    Given the app is launched
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I tap the login button
    Then I should see the product page
