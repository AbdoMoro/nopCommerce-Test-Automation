@Smoke
Feature: User should be able to register
  Scenario: User could register with valid data
    Given User open the Website homepage
    And clicks on the register Link
    When User enters valid data
    And clicks on the register button
    Then A registration confirmation message should be displayed