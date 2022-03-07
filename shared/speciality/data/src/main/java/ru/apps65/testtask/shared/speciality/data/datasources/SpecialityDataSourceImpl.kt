package ru.apps65.testtask.shared.speciality.data.datasources

import ru.apps65.testtask.database.data.dao.SpecialityDao
import ru.apps65.testtask.database.data.dto.SpecialityDto

class SpecialityDataSourceImpl(
	private val dao: SpecialityDao
) : SpecialityDataSource {

	override suspend fun getSpecialities(): List<SpecialityDto> = dao.get()
}