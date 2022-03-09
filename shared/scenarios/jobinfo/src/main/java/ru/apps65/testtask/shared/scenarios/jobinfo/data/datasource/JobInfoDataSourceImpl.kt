package ru.apps65.testtask.shared.scenarios.jobinfo.data.datasource

import ru.apps65.testtask.database.data.dao.EmployeeDao
import ru.apps65.testtask.database.data.dao.SpecialityDao
import ru.apps65.testtask.database.data.dao.SpecialityEmployeeLinkDao
import ru.apps65.testtask.shared.scenarios.jobinfo.data.api.JobInfoApiBase
import ru.apps65.testtask.shared.scenarios.jobinfo.data.models.JobInfoModel
import ru.apps65.testtask.shared.scenarios.jobinfo.data.models.ResponseModel

class JobInfoDataSourceImpl(
	private val employeeDao: EmployeeDao,
	private val specialityDao: SpecialityDao,
	private val linkDao: SpecialityEmployeeLinkDao,
	private val api: JobInfoApiBase
) : JobInfoDataSource {

	override suspend fun getRemoteData(): ResponseModel = api.getJobInfo()

	override suspend fun updateLocalData(jobInfo: JobInfoModel) {
		linkDao.insert(
			employeeDao = employeeDao,
			employees = jobInfo.employees,
			specialityDao = specialityDao,
			specialities = jobInfo.specialities,
			links = jobInfo.links
		)
	}
}