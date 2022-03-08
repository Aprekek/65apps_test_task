package ru.apps65.testtask.features.employees.details.presentation.states

import ru.apps65.testtasl.shared.employee.domain.entities.Employee

sealed class EmployeeDetailsState {

	data class Content(val employee: Employee, val age: Int?) : EmployeeDetailsState()
}