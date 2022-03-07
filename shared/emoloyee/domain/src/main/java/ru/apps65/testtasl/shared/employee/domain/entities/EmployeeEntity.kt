package ru.apps65.testtasl.shared.employee.domain.entities

import ru.apps65.testtask.shared.speciality.domain.entities.Speciality

data class Employee(
	val firstName: String,
	val lastName: String,
	val birthday: String?,
	val avatarUrl: String?,
	val speciality: List<Speciality>
)