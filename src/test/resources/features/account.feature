
Feature: Acceptance Accounts tests

  Scenario: Get Accounts
    Given I log in with Authorization token
    And I set up a GET request to Account endpoint
#    When I send the request
#    Then I get a 200 status code as response
#
#  Scenario: Create an Account
#    Given I set up a "POST" request to "/Account{id}" endpoint
#    And I set up the data:
#      """
#        {
#          "name":"Juanito"
#        }
#      """
#    When I send the request
#    Then I get a "200" status code as response
