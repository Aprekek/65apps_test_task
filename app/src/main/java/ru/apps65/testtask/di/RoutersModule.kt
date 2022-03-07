package ru.apps65.testtask.di

import org.koin.dsl.module
import ru.apps65.testtask.features.specialities.presentation.SpecialitiesRouter
import ru.apps65.testtask.navigation.routers.SpecialitiesRouterImpl

val routersModule = module {

	factory<SpecialitiesRouter> { SpecialitiesRouterImpl(router = get()) }
}