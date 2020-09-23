@java
Feature: getDriver exercises

  @java1 #ok
  Scenario: exercises
    Given I run to "quote" page
    And I print page details
    And I run to "google" page
    And I go back and forward, then refresh
    And I change resolution to "phone"
    And I change resolution to "desktop"
    And I change resolution to "max"
    Then I run to "quote" page
    And I fill required fields
    And I fill optional fields
    And I submit the page
    And I verify submitted fields saved correctly
    And I run to "quote" page
    Then I verify e-mail field behavior

  @java2 #ok
  Scenario: maps
    And I work with maps
    And I work with maps hw



