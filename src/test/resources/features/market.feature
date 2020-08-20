#MARKET TEMP FEATURE
@market
Feature: Marketing Application Test Suite

  @market1
  Scenario: Market basic test
      #Given I go to "quote" page
      #And I print page details in console
      #And I fill out required fields
      #And I fill out optional fields
      #And I wait for 2 sec
      #Then I verify that submitted fields saved correctly

      #And I wait for 2 sec
      #And I submit the form
      #When I verify email field behavior
      #And I wait for 2 sec
      #And I go to "quote" page
      #And I go back and forward, then refresh the page
      #And I wait for 2 sec
      #And I go to "google" page
      #And I wait for 2 sec
      #And I go to "ANY" page
      #And I wait for 2 sec
      #And I change res to "phone"
      #And I wait for 2 sec
      #And I change res to "desktop"
      #And I wait for 2 sec
      #And I change res to "4K"


      #And I print if number 0 is positive
      #And I print 0 th day of the week

#@usps1
#Scenario: Validate ZIP code for USPS site
  #Given I go to "usps" page
  #When I go to Lookup ZIP page by address
  #And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
  #Then I validate "94022" zip code exists in the result



 # @usps4 #Day 8 homework - not finished yet //////////////////////////////////////////////////////////
 # Scenario: Calculate price
 #  Given I go to "usps" page
 #  When I go to "calculate price" page
 #  And I select "United Kindom"


  @market3
  Scenario: Printing Logs
    Given I go to "yahoo" page
    And I print logs to the console

  @market4
  Scenario: Multi-select
    Given I go to "quote" page
    And I fill multi-select

