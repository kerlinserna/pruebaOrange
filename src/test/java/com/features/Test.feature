Feature: Yo como usuario quiero ver todos los participantes registrados para la vacante de QA.

  Background:
    Given La pagina home Orangehrmlive
    And Registrar usuario y contraseña
    And Hacer click sobre el boton login
    Then El la guiente pantallas dar click en la pestaña Recruiment
    And Dar click a la pestaña Candidates

  Scenario: Ingresar datos para Buscar
    Given Ingresar trabajo
    And Ingresar Vacancy
    And Ingresar Hiring Manager
    And Ingresar Status
    And Ingresar Candidate Name
    And Ingresar Keywords
    Then Ingresar Date of ApplicationFrom
    And  Ingresar Date of ApplicationTo
    And Method of Application
    When Buscar Candidates

