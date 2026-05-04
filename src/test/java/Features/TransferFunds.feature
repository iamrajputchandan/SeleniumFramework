@transfer
Feature: Transfer Funds in Parabank

Scenario: Successful fund transfer between accounts

Given user is logged in for transfer
When user navigates to transfer funds page
And user transfers "100" from account "12456" to account "12789"
Then transfer should be successful with confirmation message