package ru.apps65.testtask.database.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.apps65.testtask.database.data.dao.EmployeeDao
import ru.apps65.testtask.database.data.dao.SpecialityDao
import ru.apps65.testtask.database.data.dao.SpecialityEmployeeLinkDao
import ru.apps65.testtask.database.data.dto.EmployeeDto
import ru.apps65.testtask.database.data.dto.SpecialityDto
import ru.apps65.testtask.database.data.dto.SpecialityEmployeeLinkDto

@Database(
	entities = [
		EmployeeDto::class,
		SpecialityDto::class,
		SpecialityEmployeeLinkDto::class
	],
	version = 1,
	exportSchema = false
)
abstract class JobInfoDatabase : RoomDatabase() {

	companion object {

		const val NAME = "job_info_database"
	}

	abstract fun employeeDao(): EmployeeDao
	abstract fun specialityDao(): SpecialityDao
	abstract fun specialityWithEmployeeLinkDao(): SpecialityEmployeeLinkDao
}