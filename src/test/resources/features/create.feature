Feature: Verify create account
  This feature try to verify the minimun data that is required for do a post

  Scenario: verify the minimun data for a post
    Given I build body for post operation
    When I send the body and post the account