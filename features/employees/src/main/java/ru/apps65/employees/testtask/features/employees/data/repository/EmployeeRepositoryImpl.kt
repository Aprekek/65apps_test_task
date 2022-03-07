package ru.apps65.employees.testtask.features.employees.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.apps65.employees.testtask.features.employees.data.datasource.EmployeesDataSource
import ru.apps65.employees.testtask.features.employees.data.mappers.toEmployeeEntityList
import ru.apps65.employees.testtask.features.employees.domain.repository.EmployeesRepository
import ru.apps65.testtasl.shared.employee.domain.entities.Employee

class EmployeeRepositoryImpl(
	private val dataSource: EmployeesDataSource
) : EmployeesRepository {

	override suspend fun getEmployees(specialityFilter: List<Long>): List<Employee> =
		withContext(Dispatchers.IO) {
			val employees = if (specialityFilter.isEmpty())
				dataSource.getEmployees()
			else
				dataSource.getEmployees(specialityFilter)

			employees.toEmployeeEntityList()
		}
}