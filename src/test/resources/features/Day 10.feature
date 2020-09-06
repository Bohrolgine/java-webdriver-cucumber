@java
Feature: Interview questions

  @java1 # Mirror flip string reverse - ok
  Scenario: Mirror flip string reverse
    Given Reverse words in sentence "I am Automation Engineer"

  @java2 # Words in string reverse aka Speak like Yoda -ok
  Scenario: Speak like Yoda
    Given Reversing words order in sentence "I am Automation Engineer"

  @java3 #  Reverse every third character of a string -ok
  Scenario:  Reverse every third character of a string
    Given Reverse every third character in sentence "I am Automation Engineer"

  @java4 #  Reverse every third character of a string 2 -ok
  Scenario:  Reverse every third character of a string two
    Given Reverse every third character in sentence "I am Automation Engineer" two

  @java5  #  User inputs two numbers which are divided by 5. - disabled if it 5s condition - ok
          # If a number is in a range of 1..10 - print it saying it is in the range of 1 from 10.
          # If a number is in the range of 10..20 - print it saying it's in the range of 10..20.
  Scenario:  Numbers spectre
    Given Here are numbers 5 and 11

  @java6  #   Write a java program to add 2 numbers and it will print addition. How will you test the addition code?
  Scenario:  Print addition
    Given Two numbers are 5 and 11


  @ups1
  Scenario: UPS end to end first
    Given I navigate to "ups" page
    And I open Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment fields
    And I submit the shipment form
    Then I verify origin shipment fields submitted
    And I cancel the shipment form
    Then I verify shipment form is reset

  @ups2
  Scenario: UPS end to end full
    Given I navigate to "ups" page
    And I open Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment fields
    And I submit the shipment form
    Then I verify origin shipment fields submitted
    When I fill out destination shipment fields
    When I submit the shipment form
    And I set packaging type and weight
    When I submit the shipment form
    Then I verify total charges appear
    And I select cheapest delivery option
    And I submit the shipment form
    And I set description and check Saturday Delivery type
    Then I verify total charges changed
    When I submit the shipment form
    And I select Paypal payment type
    #And I submit the shipment form
    Then I review all recorded details on the review page
    And I cancel the shipment form
    Then I verify shipment form is reset

