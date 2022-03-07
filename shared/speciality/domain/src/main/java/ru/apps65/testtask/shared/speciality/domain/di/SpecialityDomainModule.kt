package ru.apps65.testtask.shared.speciality.domain.di

import org.koin.dsl.module
import ru.apps65.testtask.shared.speciality.domain.usecases.GetSpecialitiesUseCase

val specialityDomainModule = module {

	factory { GetSpecialitiesUseCase(repository = get()) }
}