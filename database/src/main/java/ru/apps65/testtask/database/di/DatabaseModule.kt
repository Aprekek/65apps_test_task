package ru.apps65.testtask.database.di

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.apps65.testtask.database.data.database.JobInfoDatabase

val databaseModule = module {
	single {
		Room.databaseBuilder(
			androidContext(),
			JobInfoDatabase::class.java,
			JobInfoDatabase.NAME
		).build()
	}

	factory { get<JobInfoDatabase>().employeeDao() }
	factory { get<JobInfoDatabase>().specialityDao() }
	factory { get<JobInfoDatabase>().specialityWithEmployeeLinkDao() }
}