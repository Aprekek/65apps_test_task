package ru.apps65.testtask.shared.scenarios.jobinfo.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.apps65.testtask.shared.scenarios.jobinfo.data.datasource.JobInfoDataSource
import ru.apps65.testtask.shared.scenarios.jobinfo.data.mappers.JobInfoResponseMapper
import ru.apps65.testtask.shared.scenarios.jobinfo.domain.repository.JobInfoRepository

class JobInfoRepositoryImpl(
	private val dataSource: JobInfoDataSource,
	private val jobInfoResponseMapper: JobInfoResponseMapper
) : JobInfoRepository {

	override suspend fun updateData() {
		withContext(Dispatchers.IO) {
			dataSource.updateLocalData(
				jobInfo = jobInfoResponseMapper.map(
					response = dataSource.getRemoteData()
				)
			)
		}
	}
}