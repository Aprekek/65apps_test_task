package ru.apps65.testtask.network.di

import org.koin.dsl.module
import ru.apps65.testtask.network.retrofit.RetrofitProvider

val networkModule = module {

	single { RetrofitProvider.retrofit }
}