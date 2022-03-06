package ru.apps65.testtask.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
	single { getSharedPreferences(androidApplication()) }
}

private fun getSharedPreferences(context: Context): SharedPreferences =
	context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)