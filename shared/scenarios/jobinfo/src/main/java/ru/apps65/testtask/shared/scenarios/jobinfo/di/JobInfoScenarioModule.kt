package ru.apps65.testtask.shared.scenarios.jobinfo.di

import org.koin.dsl.module
import ru.apps65.testtask.network.retrofit.RetrofitProvider
import ru.apps65.testtask.shared.scenarios.jobinfo.data.api.JobInfoApi
import ru.apps65.testtask.shared.scenarios.jobinfo.data.datasource.JobInfoDataSource
import ru.apps65.testtask.shared.scenarios.jobinfo.data.datasource.JobInfoDataSourceImpl
import ru.apps65.testtask.shared.scenarios.jobinfo.data.mappers.JobInfoResponseMapper
import ru.apps65.testtask.shared.scenarios.jobinfo.data.repository.JobInfoRepositoryImpl
import ru.apps65.testtask.shared.scenarios.jobinfo.domain.repository.JobInfoRepository
import ru.apps65.testtask.shared.scenarios.jobinfo.domain.scenario.UpdateJobInfoScenario

val jobInfoScenarioModule = module {

	factory { RetrofitProvider.createApi<JobInfoApi>() }

	factory<JobInfoDataSource> {
		JobInfoDataSourceImpl(
			api = get(),
			employeeDao = get(),
			specialityDao = get(),
			linkDao = get()
		)
	}

	factory<JobInfoRepository> {
		JobInfoRepositoryImpl(
			dataSource = get(),
			jobInfoResponseMapper = get()
		)
	}

	factory { JobInfoResponseMapper(employeeKeyGenerator = get()) }

	factory { UpdateJobInfoScenario(repository = get()) }
}