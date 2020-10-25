@rest
Feature: REST API autom. for Careers project

  @rest2
  Scenario: REST API Candidates CRUD
    Given I login via REST as "recruiter"
    When I create via REST "sdet" candidate
    #Then I verify via REST new "sdet" candidate is in the list
    When I add via REST "pdf" resume to a new candidate
    Then I verify via REST that "pdf" resume has been added
    When I update via REST "sdet" candidate
    #Then I verify via REST new "sdet" candidate is updated
    When I delete via REST new candidate
    #Then I verify via REST new candidate is deleted