package ru.apps65.testtask.features.specialities.presentation.states

import ru.apps65.testtask.shared.speciality.domain.entities.Speciality

sealed class SpecialitiesState {

	object Initial : SpecialitiesState()

	object Loading : SpecialitiesState()

	data class Content(val specialities: List<Speciality>) : SpecialitiesState()

	object LoadingError : SpecialitiesState()
}