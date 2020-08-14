@java
Feature: Java steps

  @java1
  Scenario: Hello world
    Given I say hello world
    When I say "hello again"
    And I say "say hello!"

  @java2
  Scenario: Methods Exercises
    Given I perform my actions with "my var" and "my VAR"

  @java3
  Scenario: A few steps with different variables
    Given I perform few steps with additional variables: "arg0" , "arg1" and "arg2"
