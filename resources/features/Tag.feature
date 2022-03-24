@Smoke
Feature: User should be able to select tags
  Scenario: Logged user could select different tags
    Given User open the Website homepage
    And logs into the website
    When User navigates to any category
    And clicks on any tag
    Then The Tag related Items should appear