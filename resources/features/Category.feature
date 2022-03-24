@Smoke
Feature: User should be able to select different Categories
  Scenario: Logged user could select different Categories
    Given User open the Website homepage
    And logs into the website
    When hover over a category
    And select a sub-category
    Then The sub-category page should be displayed