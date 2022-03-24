@Smoke
Feature: User should be able to change currency
  Scenario: Logged User could switch between currencies US-Euro
    Given User open the Website homepage
    And logs into the website
    When User clicks on the currencies dropbox and chooses Euro
    Then The product prices should be in Euro