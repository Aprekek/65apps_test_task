package ru.apps65.testtask.shared.scenarios.jobinfo.data.api

import retrofit2.http.GET
import ru.apps65.testtask.network.network.NetworkProvider
import ru.apps65.testtask.network.network.loader.RemoteDataLoader
import ru.apps65.testtask.shared.scenarios.jobinfo.data.models.ResponseModel

interface JobInfoApiBase {

	suspend fun getJobInfo(): ResponseModel
}

interface JobInfoApi : JobInfoApiBase {

	@GET("testTask.json")
	override suspend fun getJobInfo(): ResponseModel
}

interface JobInfoLegacyApi : JobInfoApiBase, RemoteDataLoader<ResponseModel> {

	override suspend fun getJobInfo(): ResponseModel {
		val path = NetworkProvider.BASE_URL + "testTask.json"
		return getData(path)
	}
}