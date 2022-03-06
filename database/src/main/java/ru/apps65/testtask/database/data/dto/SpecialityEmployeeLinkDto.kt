package ru.apps65.testtask.database.data.dto

import androidx.room.Entity

@Entity(
	tableName = "speciality_employee_link_table",
	primaryKeys = ["specialityId", "personId"]
)
data class SpecialityEmployeeLinkDto(
	val specialityId: Long,
	val personId: Long
)