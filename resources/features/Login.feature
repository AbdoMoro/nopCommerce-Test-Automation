@Smoke
Feature: User should be able to login
  Scenario: User could log in with valid email and password
    Given User open the Website homepage
    And clicks on the login Link
    When User enters valid email and password
    And clicks login button
    Then User should login successfully

  Scenario: User could reset his/her password successfully
    Given User open the Website homepage
    And clicks on the login Link
    And User clicks on forgotPassword link
    When User enters his-her email
    And clicks recover button
    Then A recovery confirmation message should be displayed
