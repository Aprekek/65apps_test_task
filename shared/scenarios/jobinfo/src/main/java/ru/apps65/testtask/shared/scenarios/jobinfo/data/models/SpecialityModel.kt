package ru.apps65.testtask.shared.scenarios.jobinfo.data.models

import com.squareup.moshi.Json

data class SpecialityModel(
	@Json(name = "specialty_id")
	val id: Long,
	val name: String
)