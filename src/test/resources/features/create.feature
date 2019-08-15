Feature: Verify create account
  This feature try to verify the minimun data that is required for do a post

  Scenario: verify the minimun data for a post
    Given I perform post operation for  with body
    When I should the body has name as

    #"00D3i000000rfF0!ARUAQOjI70WgjOmdv9Scodrzs2n2rMkx2TzrYyGavZUrONRjbKp0FPDjVqf8onzhY7WHDOtfpSXKTGfk1NbGdMPfbZ4iNcLi"