package ru.apps65.testtask.shared.speciality.domain.repositories

import ru.apps65.testtask.shared.speciality.domain.entities.Speciality

interface SpecialityRepository {

	suspend fun getSpecialities(): List<Speciality>
}