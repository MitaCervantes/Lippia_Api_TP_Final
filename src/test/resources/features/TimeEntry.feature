
Feature: Time Entry

  Background:
    Given A registered account in clockify and valid X-Api-Key
    And a valid workspaceId is entered


  @GetTimeEntry
  Scenario: 1.Get the time entries
    And I enter the userId
    When I perform a 'GET' to 'TIMEENTRY' endpoint with the 'getTimeEntries' and ''
    Then status code 200 is obtained
    And validate that the ids are not null


  @AddTimeEntry
  Scenario: 2.Add hours to project
    And I enter data in body
    When I perform a 'POST' to 'TIMEENTRY' endpoint with the 'addTimeEntry' and ''
    Then status code 201 is obtained
    Then the correct data is validated in time entry
    When I perform a 'POST' to 'ERROR' endpoint with the 'errorAddTimeEntry' and ''
    Then status code 400 is obtained
    Then I get a response object with two properties

  @Clockify
  @EditTimeEntry
  Scenario: 3.Edit a field of some timestamp.
    And I enter the userId
    When I perform a 'GET' to 'TIMEENTRY' endpoint with the 'getTimeEntries' and ''
    And I check if there is a time entry created
    And modify data of a time entry
    When I perform a 'PUT' to 'TIMEENTRY' endpoint with the 'putTimeEntry' and ''
    Then status code 200 is obtained
    And the correct data is validated in time entry