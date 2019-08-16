Feature: Acceptance Accounts tests

  Background:
    Given I log in with Authorization token

  Scenario: Get Accounts
    Given I set up a GET request to Account endpoint
    When I send the request

  Scenario: Create an Account
    Given I fill the request
    When I send the post with the name "System32"

  Scenario: Delete an Account
    Given I fill the delete request
    When I delete the account
