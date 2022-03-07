package ru.apps65.testtask.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.dsl.module
import ru.apps65.testtask.navigation.createCicerone

val globalNavigationModule = module {
	single { createCicerone() }
	single { get<Cicerone<Router>>().router }
	single { get<Cicerone<Router>>().getNavigatorHolder() }
}