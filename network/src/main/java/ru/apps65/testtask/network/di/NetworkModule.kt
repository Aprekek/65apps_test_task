package ru.apps65.testtask.network.di

import org.koin.dsl.module
import ru.apps65.testtask.network.network.NetworkProvider

val networkModule = module {

	single { NetworkProvider.retrofit }
}