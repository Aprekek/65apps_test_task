package ru.apps65.testtask.shared.scenarios.jobinfo.data.models

import ru.apps65.testtask.database.data.dto.EmployeeDto
import ru.apps65.testtask.database.data.dto.SpecialityDto
import ru.apps65.testtask.database.data.dto.SpecialityEmployeeLinkDto

data class JobInfoModel(
	val employees: List<EmployeeDto>,
	val specialities: List<SpecialityDto>,
	val links: List<SpecialityEmployeeLinkDto>
)