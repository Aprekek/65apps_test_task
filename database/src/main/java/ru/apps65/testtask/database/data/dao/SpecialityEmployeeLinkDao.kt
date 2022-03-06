package ru.apps65.testtask.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Transaction
import ru.apps65.testtask.database.data.dto.EmployeeDto
import ru.apps65.testtask.database.data.dto.SpecialityDto
import ru.apps65.testtask.database.data.dto.SpecialityEmployeeLinkDto

@Dao
interface SpecialityEmployeeLinkDao {

	@Insert(onConflict = IGNORE)
	suspend fun insert(specialityEmployeeLinkDto: List<SpecialityEmployeeLinkDto>): List<Long>

	@Transaction
	suspend fun insert(
		employeeDao: EmployeeDao,
		employees: List<EmployeeDto>,
		specialityDao: SpecialityDao,
		specialities: List<SpecialityDto>,
		links: List<SpecialityEmployeeLinkDto>
	) {
		employeeDao.insert(employees)
		specialityDao.insert(specialities)
		insert(links)
	}
}