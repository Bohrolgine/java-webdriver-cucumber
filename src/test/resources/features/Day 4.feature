@java
Feature: Java steps

  @java1 #ok
  Scenario: Hello world
    Given I say hello world
    When I say "hello again"
    And I say "say hello!"

  @java2 #ok
  Scenario: Methods Exercises
    Given I perform my actions with "my var" and "my VAR"

  @java3 #ok
  Scenario: A few steps with different variables
    Given I perform few steps with additional variables: "arg0" , "arg1" and "arg2"
