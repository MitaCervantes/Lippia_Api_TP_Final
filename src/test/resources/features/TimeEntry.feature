@Smoke
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
    And I enter the userId
    And I enter data in body
    When I perform a 'POST' to 'TIMEENTRY' endpoint with the 'addTimeEntry' and ''
    Then status code 201 is obtained
    When I perform a 'POST' to 'ERROR' endpoint with the 'errorAddTimeEntry' and ''
    Then status code 400 is obtained
    Then I get a response object with two properties


  @EditTimeEntry
  Scenario: 3.Edit a field of some timestamp
    And I enter the userId
    When I perform a 'GET' to 'TIMEENTRY' endpoint with the 'getTimeEntries' and ''
    And I check if there is a time entry created
    And modify data of a time entry
    When I perform a 'PUT' to 'TIMEENTRY' endpoint with the 'putTimeEntry' and ''
    Then status code 200 is obtained
    And the correct data is validated in time entry


  @DeleteTimeEntry
  Scenario: 4.Delete time entry from workspace
    And I enter the userId
    And I enter data in body
    When I perform a 'POST' to 'TIMEENTRY' endpoint with the 'addTimeEntry' and ''
    Then status code 201 is obtained
    And a timeEntryId is obtained and set to url
    When I perform a 'DELETE' to 'EMPTY' endpoint with the 'deleteTimeEntry' and ''
    And status code 204 is obtained
    When I perform a 'DELETE' to 'ERROR' endpoint with the 'errorDeleteTimeEntry' and ''
    Then status code 405 is obtained
    And expected response is obtained in 'ERROR'