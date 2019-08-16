Feature: Create lead
  @LeadCreation
  Scenario: Create a lead sending correct json
    Given a user sets json object with required fields
      | Company	 	| KingPin      |
      | LastName	| WilsonFisk   |
    When the user creates the lead
    Then the status code is 201