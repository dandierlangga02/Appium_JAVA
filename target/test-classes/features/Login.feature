Feature: Login to Sample App

  Scenario: Successful Login
    Given the app is launched
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I tap the login button
    Then I should see the product page

  Scenario: Failed Login Password
    Given the app is launched
    When I enter username "standard_user"
    And I enter password "Invalid_Password"
    And I tap the login button
    Then I Verify Error Massege

  Scenario: Failed Login Username
    Given the app is launched
    When I enter username "Invalid_username"
    And I enter password "secret_sauce"
    And I tap the login button
    Then I Verify Error Massege
