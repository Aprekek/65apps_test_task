package ru.apps65.testtask

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.apps65.testtask.di.globalNavigationModule

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)

			modules(
				globalNavigationModule,
			)
		}
	}
}