package ru.apps65.employees.testtask.features.employees.data.datasource

import ru.apps65.testtask.database.data.dto.EmployeeDto
import ru.apps65.testtask.database.data.dto.SpecialityDto

interface EmployeesDataSource {

	suspend fun getEmployees(): Map<EmployeeDto, List<SpecialityDto>>

	suspend fun getEmployees(specialityFilter: List<Long>): Map<EmployeeDto, List<SpecialityDto>>
}