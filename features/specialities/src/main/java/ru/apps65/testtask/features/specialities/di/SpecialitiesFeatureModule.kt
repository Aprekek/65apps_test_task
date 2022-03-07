package ru.apps65.testtask.features.specialities.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.apps65.testtask.features.specialities.presentation.SpecialitiesViewModel

val specialitiesFeatureModule = module {
	viewModel {
		SpecialitiesViewModel(
			router = get(),
			getSpecialitiesUseCase = get(),
			updateJobInfoScenario = get()
		)
	}
}