package ru.apps65.testtask.shared.scenarios.jobinfo.data.api

import ru.apps65.testtask.network.network.loader.LegacyRemoteDataLoader
import ru.apps65.testtask.shared.scenarios.jobinfo.data.models.ResponseModel

class JobInfoLegacyApiImpl(
	private val dataLoader: LegacyRemoteDataLoader<ResponseModel>,
) : JobInfoLegacyApi {

	override suspend fun getData(path: String): ResponseModel {
		return dataLoader.getData(path)
	}
}