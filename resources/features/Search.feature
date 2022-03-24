@Smoke
Feature: User should be able to search
  Scenario: Logged User could search for any product
    Given User open the Website homepage
    And logs into the website
    When user enters the search word
    And clicks on the search button
    Then The search results appears
    And They should be related to the search word