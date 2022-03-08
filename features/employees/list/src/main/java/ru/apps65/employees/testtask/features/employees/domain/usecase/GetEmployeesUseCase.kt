package ru.apps65.employees.testtask.features.employees.domain.usecase

import ru.apps65.employees.testtask.features.employees.domain.repository.EmployeesRepository
import ru.apps65.testtasl.shared.employee.domain.entities.Employee

class GetEmployeesUseCase(
	private val repository: EmployeesRepository
) {

	suspend operator fun invoke(specialityFilter: List<Long>): List<Employee> =
		repository.getEmployees(specialityFilter)
}