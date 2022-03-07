package ru.apps65.testtask.shared.scenarios.jobinfo.data.models

import com.squareup.moshi.Json

data class EmployeeModel(
	@Json(name = "f_name")
	val firstName: String,
	@Json(name = "l_name")
	val lastName: String,
	val birthday: String?,
	@Json(name = "avatr_url")
	val avatarUrl: String?,
	@Json(name = "specialty")
	val speciality: List<SpecialityModel>
)