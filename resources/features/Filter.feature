@Smoke
Feature: User should be able to filter the results
  Scenario: Logged user could filter with color
    Given User open the Website homepage
    And logs into the website
    When User opens "Apparel" > "Shoes" category
    And Selects "Red" Colour
    Then the items displayed should be in the chosen colour