package ru.apps65.testtasl.shared.employee.domain.entities

import ru.apps65.testtask.shared.speciality.domain.entities.Speciality
import java.io.Serializable

data class Employee(
	val id: Long,
	val firstName: String,
	val lastName: String,
	val birthday: String?,
	val avatarUrl: String?,
	val speciality: List<Speciality>
) : Serializable