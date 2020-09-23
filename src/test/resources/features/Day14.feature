#QUOTE OOP DAY 14 - QUOTE.FEATURE 1st-one just duplicated from Day 13
@quoteOOP
Feature: Quote OOP

  @quoteOOP1 # - ok
  Scenario: Required fields for quote OOP
    Given I open "quote" page
    #And I print page details oop
    When I fill out required fields for "user" oop
    And I submit the form oop
    Then I verify required fields for "user" oop

  @quoteOOP1outline # - ok
  Scenario Outline: Required fields for quote OOP outline
    Given I open "quote" page
    #And I print page details oop
    When I fill out required fields for "<role>" oop
    And I submit the form oop
    Then I verify required fields for "<role>" oop
    Examples:
      | role  |
      | user  |
      | admin |

  @quoteOOP2 # - ok
  Scenario: Optional fields for quote OOP
    Given I open "quote" page
    When I fill out required fields for "user" oop
    When I fill out optional fields for "user" oop
    And I submit the form oop
    Then I verify required fields for "user" oop
    Then I verify optional fields for "user" oop

  @quoteOOP3 # - ok
  Scenario: Required fields test oop
    Given I open "quote" page
    And I submit the form oop
    Then I see "username" error message "This field is required."
    And I see "email" error message "This field is required."
    And I see "password" error message "This field is required."
    And I see "name" error message "This field is required."
    And I see "agreedToPrivacyPolicy" error message "- Must check!"

  @quoteOOP4 # - ok
  Scenario: Market username test oop
    Given I open "quote" page
    When I fill out "username" field with "a"
    And I submit the form oop
    Then I see "username" error message "Please enter at least 2 characters."
    When I fill out "username" field with "ab"
    Then I don't see "username" error message

  @quoteOOP5  # - ok
  Scenario: Market email test oop
    Given I open "quote" page
    When I fill out "email" field with "john"
    And I submit the form oop
    Then I see "email" error message "Please enter a valid email address."
    When I fill out "email" field with "john@example.com"
    Then I don't see "email" error message

  @quoteOOP6 # - ok
  Scenario: Market passwords test oop
    Given I open "quote" page
    When I fill out "password" field with "1234"
    And I submit the form oop
    Then I see "password" error message "Please enter at least 5 characters."
    When I fill out "password" field with "12345"
    Then I don't see "password" error message
    When I fill out "confirmPassword" field with "1234"
    And I submit the form oop
    Then I see "confirmPassword" error message "Please enter at least 5 characters."
    When I fill out "confirmPassword" field with "54321"
    Then I see "confirmPassword" error message "Passwords do not match!"
    When I fill out "confirmPassword" field with "12345"
    Then I don't see "confirmPassword" error message

  @quoteOOP7 # - ok
  Scenario: Market name test oop
    Given I open "quote" page
    When I fill out name field with first name "John" and last name "Doe"
    Then I verify "name" field value "John Doe"
    When I fill out name field with first name "John", middle name "Richard", last name "Doe"
    Then I verify "name" field value "John Richard Doe"
