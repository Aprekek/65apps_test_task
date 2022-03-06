package ru.apps65.testtask.database.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee_table")
data class EmployeeDto(
	@PrimaryKey
	val personId: Long,
	val firstName: String,
	val lastName: String,
	val birthday: String,
	val avatarUrl: String?,
)