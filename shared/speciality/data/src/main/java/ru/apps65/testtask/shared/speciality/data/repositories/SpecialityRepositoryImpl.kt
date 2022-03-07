package ru.apps65.testtask.shared.speciality.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.apps65.testtask.shared.speciality.data.datasources.SpecialityDataSource
import ru.apps65.testtask.shared.speciality.data.mappers.toEntitiesList
import ru.apps65.testtask.shared.speciality.domain.entities.Speciality
import ru.apps65.testtask.shared.speciality.domain.repositories.SpecialityRepository

class SpecialityRepositoryImpl(
	private val dataSource: SpecialityDataSource
) : SpecialityRepository {

	override suspend fun getSpecialities(): List<Speciality> =
		withContext(Dispatchers.IO) {
			dataSource.getSpecialities().toEntitiesList()
		}
}