package ru.apps65.employees.testtask.features.employees.presentation.states

import ru.apps65.testtasl.shared.employee.domain.entities.Employee

sealed class EmployeesState {

	object Initial : EmployeesState()

	object Loading : EmployeesState()

	data class Content(val employees: List<Employee>) : EmployeesState()
	object EmptyContent : EmployeesState()

	object LoadingError : EmployeesState()
}