package ru.apps65.employees.testtask.features.employees.di

import org.koin.dsl.module
import ru.apps65.employees.testtask.features.employees.data.datasource.EmployeesDataSource
import ru.apps65.employees.testtask.features.employees.data.datasource.EmployeesDataSourceImpl
import ru.apps65.employees.testtask.features.employees.data.repository.EmployeeRepositoryImpl
import ru.apps65.employees.testtask.features.employees.domain.repository.EmployeesRepository
import ru.apps65.employees.testtask.features.employees.domain.usecase.GetEmployeesUseCase

val employeesFeatureModule = module {

	factory<EmployeesDataSource> { EmployeesDataSourceImpl(dao = get()) }

	factory<EmployeesRepository> { EmployeeRepositoryImpl(dataSource = get()) }

	factory { GetEmployeesUseCase(repository = get()) }
}