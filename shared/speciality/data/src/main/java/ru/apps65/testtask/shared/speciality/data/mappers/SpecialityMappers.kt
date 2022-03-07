package ru.apps65.testtask.shared.speciality.data.mappers

import ru.apps65.testtask.database.data.dto.SpecialityDto
import ru.apps65.testtask.shared.speciality.domain.entities.Speciality

fun SpecialityDto.toEntity() = Speciality(id = specId, name = name)
fun List<SpecialityDto>.toEntitiesList() = map(SpecialityDto::toEntity)