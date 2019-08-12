Feature: Acceptance tests

  Scenario: Get a account
    Given I set up a GET request
    When I send the request to /Account endpoint
    Then I get a 200 status code as response
