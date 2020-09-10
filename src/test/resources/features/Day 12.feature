@java
Feature: Interview Coding Tasks

  @java1   #Write a function that finds any two element of an array result in sum - ok
  Scenario: Write a function that finds any two element of an array result in sum
    Given Write a function that finds any two element of an array result in sum

  @java2   #Write a function that find two max numbers in an array - ok
  Scenario: Write a function that find two max numbers in an array
    Given Write a function that find two max numbers in an array

  @java3   #Write a function that find factorial of a number - ok
  Scenario: Write a function that find factorial of a number
    Given Write a function that find factorial of a number

  @java4   #Write a function that performs a binary search - ok
  Scenario: Write a function that performs a binary search
    Given Write a function that performs a binary search

  @usps3 # - ok
  Scenario: Wrong store id does not match
    Given I go to "usps" page
    When I go to "Postal Store" tab
    And I enter "12345" into store search
    Then I search and validate no products found

  @usps4 # - ok
  Scenario: One item found
    Given I go to "usps" page
    When I go to "Stamps" under "Postal Store"
    And choose mail service Priority Mail
    Then I verify 1 items found

  @usps5 # - ok
  Scenario: Verify color
    Given I go to "usps" page
    When I go to "Stamps" under "Postal Store"
    When I unselect Stamps checkbox
    And select Vertical stamp Shape
    And I click Blue color
    Then I verify "Blue" and "Vertical" filters
    Then I verify 12 items found
    And I verify that items below 12 dollars exists

  @usps6 # - ok
  Scenario: Verify location
    Given I go to "usps" page
    When I perform "Passports" search
    And I select "Passport Application" in results
    And I click "Schedule an Appointment" button
    And verify "Passport Renewal" service exists

  @usps7
  Scenario: PO Box
    Given I go to "usps" page
    When I go to "PO Boxes" under "Track & Manage"
    And I reserve new PO box for "94022"
    Then I verify that "Los Altos — Post Office™" present
    And I verify that "Size 5-XL" PO Box is available in "Los Altos — Post Office™"




