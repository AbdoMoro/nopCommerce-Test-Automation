@Smoke
Feature: User should be able to add products to Shopping cart
  Scenario: Logged user could add different products to Shopping cart
    Given User open the Website homepage
    And logs into the website
    When User navigates to any product
    And clicks on the Add to "shopping cart" button
    Then a confirmation message should be displayed and the item added to the "shopping cart"