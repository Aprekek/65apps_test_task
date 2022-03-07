package ru.apps65.employees.testtask.features.employees.data.mappers

import ru.apps65.testtask.database.data.dto.SpecialityDto
import ru.apps65.testtask.shared.speciality.domain.entities.Speciality

fun SpecialityDto.toEntity() = Speciality(id = specId, name = name)

fun List<SpecialityDto>.toEntityList() = map(SpecialityDto::toEntity)