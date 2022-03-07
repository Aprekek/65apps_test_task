package ru.apps65.employees.testtask.features.employees.di

import org.koin.dsl.module
import ru.apps65.employees.testtask.features.employees.domain.usecase.GetEmployeesUseCase

val employeesFeatureModule = module {

	factory { GetEmployeesUseCase(repository = get()) }
}