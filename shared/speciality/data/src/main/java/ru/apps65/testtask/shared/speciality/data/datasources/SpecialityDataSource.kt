package ru.apps65.testtask.shared.speciality.data.datasources

import ru.apps65.testtask.database.data.dto.SpecialityDto

interface SpecialityDataSource {

	suspend fun getSpecialities(): List<SpecialityDto>
}