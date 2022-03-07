package ru.apps65.testtask.shared.scenarios.jobinfo.data.api

import retrofit2.http.GET
import ru.apps65.testtask.shared.scenarios.jobinfo.data.models.ResponseModel

interface JobInfoApi {

	@GET("testTask.json")
	suspend fun getJobInfo(): ResponseModel
}