Feature: Dummy Rest Api Functionality Scenarios

  Scenario: Get All Employees data
    Given Anonymous Client is ready for the request
    When Call to the all employees URL "/api/v1/employees"
    Then List of employees is returned

  Scenario Outline: Dummy Rest Api GET
    Given Get Call to "<url>"
    Then Response "<responseMessage>" is validated

    Examples:
      | url                | responseMessage                        |
      | /api/v1/employee/1 | Successfully! Record has been fetched. |