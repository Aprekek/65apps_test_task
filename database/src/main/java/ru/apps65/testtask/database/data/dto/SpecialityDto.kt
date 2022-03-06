package ru.apps65.testtask.database.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "speciality_table")
data class SpecialityDto(
	@PrimaryKey
	val specId: Long,
	val name: String
)