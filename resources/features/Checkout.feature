@Smoke
Feature: Checkout
  Scenario: Create successful Order
    Given User open the Website homepage
    And logs into the website
    And adds products to the shopping cart
    When hits checkout and completes the required data
    Then a confirmation message should be displayed