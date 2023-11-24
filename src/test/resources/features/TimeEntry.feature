@Clockify
Feature: Time Entry

  Background:
    Given Una cuenta registrada en clockify y X-Api-Key valida
    And ingreso un workspaceId valido


  @Get_TimeEntry
  Scenario: 1. Get - Consultar las horas registradas
    And ingreso el userId para consultar
    When I perform a 'GET' to 'TIMEENTRY' endpoint with the 'getTimeEntries' and ''
    Then se obtuvo el status code 200
    Then se valida que los id de las entradas no sean null
