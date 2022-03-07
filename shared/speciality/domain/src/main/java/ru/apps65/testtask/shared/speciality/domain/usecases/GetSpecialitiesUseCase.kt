package ru.apps65.testtask.shared.speciality.domain.usecases

import ru.apps65.testtask.shared.speciality.domain.entities.Speciality
import ru.apps65.testtask.shared.speciality.domain.repositories.SpecialityRepository

class GetSpecialitiesUseCase(
	private val repository: SpecialityRepository
) {

	suspend operator fun invoke(): List<Speciality> = repository.getSpecialities()
}