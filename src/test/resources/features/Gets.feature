Feature: Verify GET methods
  Scenario: Verify get lead by id
    Given A lead exists with Id 00Q3i000002AwJKEA
    When a user retrieves the lead by Id
    Then the status code is 200
