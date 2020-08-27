@java
Feature: Interview questions

  @java1 # Write a function that prints all numbers from 0 up to n - ok
  Scenario: Interview coding task 3
    Given Prints all numbers from 90 up to -10

  @java2 #Write a function that prints all integer array - ok
  Scenario:integer array
    Given Print all integer array

  @java3 #Fizz & Buzz - ok
  Scenario:Fizz & Buzz
    Given Fizz & Buzz functions up to 112

  @java4 #USPS Scenarios - 02 - previous-one is in Day 7 -ok
  Scenario: USPS - Calculate the Price
    Given I navigate to "usps" page
    And I go to calculate price page
    And I select "Canada" with "Postcard" shape
    And I define "2" qty
    Then I validate the price is "$2.40"

    @java4 # #USPS Scenarios - 03 -ok
  Scenario: USPS - Verify location
      Given I go to "usps" page
      When I perform "Free Boxes" search
      And I set "Mail & Ship" in filters
      Then I verify that "7" results found
      When I select "Priority Mail | USPS" in results
      And I click "Ship Now" button
      Then I validate that Sign In is required

    @java5 # #USPS Scenarios - 04 -ok
    Scenario: USPS - Phone number of the nearest Accountable Mail Pickup Service Post
      Given I go to "usps" page
      When I go to Find a Location Page
      And I filter by "Post Offices" Location Types, "Pickup Services" Services,"Accountable Mail" Available Services
      And I fill in "4970 El Camino Real 110" street, "Los Altos" city, "CA" state
      Then I print the phone number and validate it is "800-275-8777"

    @java6 # #USPS Scenarios - 05
    Scenario: Quadcopters delivery
      Given I go to "usps" page
      When I go to "Help" tab
      And I perform "Quadcopters delivery" help search
      Then I verify that no results of "Quadcopters delivery" available in help search