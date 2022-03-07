package ru.apps65.testtask.shared.scenarios.jobinfo.data.datasource

import ru.apps65.testtask.shared.scenarios.jobinfo.data.models.JobInfoModel
import ru.apps65.testtask.shared.scenarios.jobinfo.data.models.ResponseModel

interface JobInfoDataSource {

	suspend fun getRemoteData(): ResponseModel

	suspend fun updateLocalData(jobInfo: JobInfoModel)
}