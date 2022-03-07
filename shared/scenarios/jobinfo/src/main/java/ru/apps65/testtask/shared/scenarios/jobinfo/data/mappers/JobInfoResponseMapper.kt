package ru.apps65.testtask.shared.scenarios.jobinfo.data.mappers

import ru.apps65.testtask.database.data.EmployeeKeyGenerator
import ru.apps65.testtask.database.data.dto.EmployeeDto
import ru.apps65.testtask.database.data.dto.SpecialityDto
import ru.apps65.testtask.database.data.dto.SpecialityEmployeeLinkDto
import ru.apps65.testtask.shared.scenarios.jobinfo.data.models.EmployeeModel
import ru.apps65.testtask.shared.scenarios.jobinfo.data.models.JobInfoModel
import ru.apps65.testtask.shared.scenarios.jobinfo.data.models.ResponseModel
import ru.apps65.testtask.shared.scenarios.jobinfo.data.models.SpecialityModel
import ru.apps65.testtask.shared.scenarios.jobinfo.data.validators.JobInfoResponseValidator

class JobInfoResponseMapper(
	private val employeeKeyGenerator: EmployeeKeyGenerator
) {

	fun map(response: ResponseModel): JobInfoModel {
		val employees = mutableListOf<EmployeeDto>()
		val specialities = HashSet<SpecialityDto>()
		val links = mutableListOf<SpecialityEmployeeLinkDto>()

		response.response.forEach { employeeModel ->
			val employeeId = employeeKeyGenerator.getNewKey()

			validateAndMapEmployee(employees, employeeModel, employeeId)

			employeeModel.speciality.forEach { specialityModel ->
				validateAndMapSpeciality(specialities, specialityModel)
				addLinkBetweenEmployeeAndSpeciality(links, specialityModel.id, employeeId)
			}
		}
		employeeKeyGenerator.saveKey()

		return JobInfoModel(
			employees = employees,
			specialities = specialities.toList(),
			links = links
		)
	}

	private fun validateAndMapEmployee(
		employees: MutableList<EmployeeDto>,
		employeeModel: EmployeeModel,
		employeeId: Long
	) {
		employees.add(
			EmployeeDto(
				personId = employeeId,
				firstName = JobInfoResponseValidator.validateName(employeeModel.firstName),
				lastName = JobInfoResponseValidator.validateName(employeeModel.lastName),
				birthday = JobInfoResponseValidator.validateDate(employeeModel.birthday),
				avatarUrl = employeeModel.avatarUrl
			)
		)
	}

	private fun validateAndMapSpeciality(
		specialities: HashSet<SpecialityDto>,
		specialityModel: SpecialityModel
	) {
		specialities.add(specialityModel.toDatabaseEntity())
	}

	private fun addLinkBetweenEmployeeAndSpeciality(
		links: MutableList<SpecialityEmployeeLinkDto>,
		specialityId: Long,
		employeeId: Long
	) {
		links.add(SpecialityEmployeeLinkDto(specialityId = specialityId, personId = employeeId))
	}
}
