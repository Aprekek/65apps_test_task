package ru.apps65.testtask.shared.scenarios.jobinfo.di

import android.os.Build
import com.squareup.moshi.JsonAdapter
import org.koin.dsl.module
import ru.apps65.testtask.network.network.NetworkProvider
import ru.apps65.testtask.shared.scenarios.jobinfo.data.api.JobInfoApi
import ru.apps65.testtask.shared.scenarios.jobinfo.data.api.JobInfoApiBase
import ru.apps65.testtask.shared.scenarios.jobinfo.data.api.JobInfoLegacyApiImpl
import ru.apps65.testtask.shared.scenarios.jobinfo.data.datasource.JobInfoDataSource
import ru.apps65.testtask.shared.scenarios.jobinfo.data.datasource.JobInfoDataSourceImpl
import ru.apps65.testtask.network.network.loader.LegacyRemoteDataLoader
import ru.apps65.testtask.shared.scenarios.jobinfo.data.mappers.JobInfoResponseMapper
import ru.apps65.testtask.shared.scenarios.jobinfo.data.models.ResponseModel
import ru.apps65.testtask.shared.scenarios.jobinfo.data.repository.JobInfoRepositoryImpl
import ru.apps65.testtask.shared.scenarios.jobinfo.domain.repository.JobInfoRepository
import ru.apps65.testtask.shared.scenarios.jobinfo.domain.scenario.UpdateJobInfoScenario

val jobInfoScenarioModule = module {

	factory<JsonAdapter<ResponseModel>> { NetworkProvider.moshi.adapter(ResponseModel::class.java) }

	factory { LegacyRemoteDataLoader<ResponseModel>(jsonAdapter = get()) }

	factory<JobInfoApiBase> {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			NetworkProvider.createApi<JobInfoApi>()
		} else {
			JobInfoLegacyApiImpl(dataLoader = get())
		}
	}

	factory<JobInfoDataSource> {
		JobInfoDataSourceImpl(
			employeeDao = get(),
			specialityDao = get(),
			linkDao = get(),
			api = get()
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