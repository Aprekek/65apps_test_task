package ru.apps65.testtask.shared.scenarios.jobinfo.domain.scenario

import ru.apps65.testtask.shared.scenarios.jobinfo.domain.repository.JobInfoRepository

class UpdateJobInfoScenario(
	private val repository: JobInfoRepository
) {

	suspend operator fun invoke() {
		repository.updateData()
	}
}