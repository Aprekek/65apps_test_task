package ru.apps65.testtask

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.apps65.testtask.database.di.databaseModule
import ru.apps65.testtask.di.appModule
import ru.apps65.testtask.di.globalNavigationModule
import ru.apps65.testtask.di.routersModule
import ru.apps65.testtask.features.specialities.di.specialitiesFeatureModule
import ru.apps65.testtask.network.di.networkModule
import ru.apps65.testtask.shared.scenarios.jobinfo.di.jobInfoScenarioModule
import ru.apps65.testtask.shared.speciality.data.di.specialityDataModule
import ru.apps65.testtask.shared.speciality.domain.di.specialityDomainModule

class App : MultiDexApplication() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)

			modules(
				appModule,
				globalNavigationModule,
				databaseModule,
				networkModule,
				specialityDomainModule,
				specialityDataModule,
				specialitiesFeatureModule,
				jobInfoScenarioModule,
				routersModule,
			)
		}
	}
}