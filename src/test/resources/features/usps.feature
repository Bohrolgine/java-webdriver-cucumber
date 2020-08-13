@usps
Feature: Usps App Test Suite

  @usps1
  Scenario Outline: Validate ZIP code for USPS site for different addresses
    Given I go to "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "<street>" street, "<city>" city, "<state>" state
    Then I validate "<zip>" zip code exists in the result
    Examples:
      | street              | city      | state | zip   |
      | 4970 El Camino Real | Los Altos | CA    | 94022 |
      | 11 Wall St          | New York  | NY    | 10005 |
      | 111 S Michigan Ave  | Chicago   | IL    | 60603 |


  @usps5
  Scenario: Phone number of the nearest Accountable Mail Pickup Service Post Office for PCS
    Given I go to "usps" page
    When I go to Find a Location Page
    And I filter by "Post Offices" Location Types, "Pickup Services" Services, "Accountable Mail" Available Services
    #And I fill in "4970 El Camino Real 110" street, "Los Altos" city, "CA" state
    #Then I print the phone number and validate it is "800-275-8777"