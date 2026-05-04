@account @regression
Feature: Account Overview in Parabank

  Scenario: User views account balance successfully

    Given user is logged in for account overview
    When user navigates to accounts overview page
    Then account balance should be displayed