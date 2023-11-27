
Feature: Time Entry

  Background:
    Given Una cuenta registrada en clockify y X-Api-Key valida
    And ingreso un workspaceId valido


  @GetTimeEntry
  Scenario: 1.Consultar las horas registradas
    And ingreso el userId para consultar
    When I perform a 'GET' to 'TIMEENTRY' endpoint with the 'getTimeEntries' and ''
    Then se obtuvo el status code 200
    Then se valida que los id no sean null

  @Clockify
  @AddTimeEntry
  Scenario: 2.Agregar horas a un proyecto
    And ingreso datos en body
    When I perform a 'POST' to 'TIMEENTRY' endpoint with the 'addTimeEntry' and ''
    Then se obtuvo el status code 201
    Then se valida datos correctos en time entry
    When I perform a 'POST' to 'ERROR' endpoint with the 'errorAddTimeEntry' and ''
    Then se obtuvo el status code 400
    Then se obtiene un objeto response con dos propiedades
