package ru.apps65.testtask.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.apps65.testtask.database.data.dto.SpecialityDto

@Dao
interface SpecialityDao {

	@Insert(onConflict = REPLACE)
	suspend fun insert(specialities: List<SpecialityDto>): List<Long>

	@Query("SELECT * FROM speciality_table")
	suspend fun get(): List<SpecialityDto>
}