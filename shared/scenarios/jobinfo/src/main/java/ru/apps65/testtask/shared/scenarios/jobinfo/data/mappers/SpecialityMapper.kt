package ru.apps65.testtask.shared.scenarios.jobinfo.data.mappers

import ru.apps65.testtask.database.data.dto.SpecialityDto
import ru.apps65.testtask.shared.scenarios.jobinfo.data.models.SpecialityModel

fun SpecialityModel.toDatabaseEntity() = SpecialityDto(specId = id, name = name)