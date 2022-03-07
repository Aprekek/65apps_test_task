package ru.apps65.employees.testtask.features.employees.data.mappers

import ru.apps65.testtask.database.data.dto.EmployeeDto
import ru.apps65.testtask.database.data.dto.SpecialityDto
import ru.apps65.testtasl.shared.employee.domain.entities.Employee

fun Map<EmployeeDto, List<SpecialityDto>>.toEmployeeEntityList(): List<Employee> =
	map {
		with(it.key) {
			Employee(
				id = personId,
				firstName = firstName,
				lastName = lastName,
				birthday = birthday,
				avatarUrl = avatarUrl,
				speciality = it.value.toEntityList()
			)
		}
	}