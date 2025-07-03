Feature: Sorting
  @Sorting1
  Scenario: Sorting
    Given user Login app swag lab
    And user see the product page
    And user click button Filter
    And user Choose Price low to high
    Then user Verify Price Low to High

  @Sorting2
  Scenario: Sorting
    Given user Login app swag lab
    And user see the product page
    And user click button Filter
    And user Choose Price High to Low
    Then user Verify Price High to Low

  @Sorting3
  Scenario: Sorting
    Given user Login app swag lab
    And user see the product page
    And user click button Filter
    And user Choose A to Z
    Then user Verify A to Z

  @Sorting4
  Scenario: Sorting
    Given user Login app swag lab
    And user see the product page
    And user click button Filter
    And user Choose Z to A
    Then user Verify Z to A



