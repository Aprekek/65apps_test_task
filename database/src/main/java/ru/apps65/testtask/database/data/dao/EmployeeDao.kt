package ru.apps65.testtask.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.apps65.testtask.database.data.dto.EmployeeDto
import ru.apps65.testtask.database.data.dto.SpecialityDto

@Dao
interface EmployeeDao {

	@Insert(onConflict = REPLACE)
	suspend fun insert(employees: List<EmployeeDto>)

	@Query(
		"SELECT employee_table.*, speciality_table.* " +
			"FROM employee_table " +
			"JOIN ( " +
			"    SELECT specialityId AS spec_Id, personId AS pers_Id " +
			"    FROM speciality_employee_link_table) " +
			"ON personId = pers_Id " +
			"JOIN speciality_table ON specId = spec_Id " +
			"OR personId IN (SELECT personId FROM speciality_employee_link_table WHERE specialityId != spec_Id)"
	)
	suspend fun get(): Map<EmployeeDto, List<SpecialityDto>>

	@Query(
		"SELECT employee_table.*, speciality_table.* " +
			"FROM employee_table " +
			"JOIN ( " +
			"    SELECT specialityId AS spec_Id, personId AS pers_Id " +
			"    FROM speciality_employee_link_table  " +
			"    WHERE spec_Id IN (:specialityFilter)   " +
			"    GROUP by pers_Id HAVING COUNT(pers_Id) >= :size) " +
			"ON personId = pers_Id " +
			"JOIN speciality_table ON specId = spec_Id " +
			"OR personId IN (SELECT personId FROM speciality_employee_link_table WHERE specialityId != spec_Id)"
	)
	suspend fun getEmployeeWithFilter(specialityFilter: List<Long>, size: Int): Map<EmployeeDto, List<SpecialityDto>>
}