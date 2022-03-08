package ru.apps65.testtask.di

import org.koin.dsl.module
import ru.apps65.employees.testtask.features.employees.presentation.EmployeesRouter
import ru.apps65.testtask.features.employees.details.presentation.EmployeeDetailsRouter
import ru.apps65.testtask.features.specialities.presentation.SpecialitiesRouter
import ru.apps65.testtask.navigation.routers.EmployeeDetailsRouterImpl
import ru.apps65.testtask.navigation.routers.EmployeesRouterImpl
import ru.apps65.testtask.navigation.routers.SpecialitiesRouterImpl

val routersModule = module {

	factory<SpecialitiesRouter> { SpecialitiesRouterImpl(router = get()) }
	factory<EmployeesRouter> { EmployeesRouterImpl(router = get()) }
	factory<EmployeeDetailsRouter> { EmployeeDetailsRouterImpl(router = get()) }
}