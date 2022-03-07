package ru.apps65.testtask.shared.speciality.data.di

import org.koin.dsl.module
import ru.apps65.testtask.shared.speciality.data.datasources.SpecialityDataSource
import ru.apps65.testtask.shared.speciality.data.datasources.SpecialityDataSourceImpl
import ru.apps65.testtask.shared.speciality.data.repositories.SpecialityRepositoryImpl
import ru.apps65.testtask.shared.speciality.domain.repositories.SpecialityRepository

val specialityDataModule = module {

	factory<SpecialityDataSource> { SpecialityDataSourceImpl(dao = get()) }

	factory<SpecialityRepository> { SpecialityRepositoryImpl(dataSource = get()) }
}