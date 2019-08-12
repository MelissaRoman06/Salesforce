Feature: Acceptance tests
  Background:
    Given I log in salesforce page with username and password

  Scenario: Get a account by id
    Given I set up a "GET" request to "/account/{id}" endpoint
    When I send the request
    Then I get a "200" status code as response
