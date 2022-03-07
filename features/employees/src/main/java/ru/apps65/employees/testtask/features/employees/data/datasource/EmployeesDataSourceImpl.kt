package ru.apps65.employees.testtask.features.employees.data.datasource

import ru.apps65.testtask.database.data.dao.EmployeeDao

class EmployeesDataSourceImpl(
	private val dao: EmployeeDao
) : EmployeesDataSource {

	override suspend fun getEmployees() = dao.get()

	override suspend fun getEmployees(specialityFilter: List<Long>) =
		dao.getEmployeeWithFilter(specialityFilter, specialityFilter.size)
}