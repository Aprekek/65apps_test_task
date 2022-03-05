package ru.apps65.testtask.navigation

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

fun createCicerone(): Cicerone<Router> = Cicerone.create().apply {
	router.newRootScreen(getRootScreen())
}