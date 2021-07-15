Feature: Testing Multiplication logic

  @Multiply1 @MultiplyAll
  Scenario: multiply two numbers
    Given I have 2 and 3
    When I multiply
    Then I verify result is 35

  @Multiply2 @MultiplyAll
  Scenario: add two numbers
    Given I have 34 and 22
    When I add
    Then I verify result is 33

