package ru.apps65.employees.testtask.features.employees.presentation

import ru.apps65.testtasl.shared.employee.domain.entities.Employee

interface EmployeesRouter {

	fun navigateToEmployeeDetails(employee: Employee)

	fun navigateExit()
}