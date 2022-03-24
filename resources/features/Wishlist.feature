@Smoke
Feature: User should be able to add products to Wishlist
  Scenario: Logged user could add different products to Wishlist
    Given User open the Website homepage
    And logs into the website
    When User navigates to any product
    And clicks on the Add to "wishlist" button
    Then a confirmation message should be displayed and the item added to the "wishlist"