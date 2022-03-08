package ru.apps65.employees.testtask.features.employees.domain.repository

import ru.apps65.testtasl.shared.employee.domain.entities.Employee

interface EmployeesRepository {

	suspend fun getEmployees(specialityFilter: List<Long>): List<Employee>
}