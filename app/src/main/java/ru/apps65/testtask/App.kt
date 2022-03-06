package ru.apps65.testtask

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.apps65.testtask.database.di.databaseModule
import ru.apps65.testtask.di.appModule
import ru.apps65.testtask.di.globalNavigationModule
import ru.apps65.testtask.network.di.networkModule

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)

			modules(
				appModule,
				globalNavigationModule,
				databaseModule,
				networkModule,
			)
		}
	}
}