package ru.apps65.testtask.shared.scenarios.jobinfo.data.validators

object JobInfoResponseValidator {

	fun validateDate(date: String?): String {
		return date?.split('-')?.let { splittedDate ->
			if (splittedDate.first().length == 4) {
				val validDate = StringBuilder(splittedDate.last())

				for (i in (splittedDate.size - 2) downTo 0 step 1) {
					validDate
						.append('.')
						.append(splittedDate[i])
				}

				validDate.toString()
			} else {
				splittedDate.joinToString(".")
			}
		} ?: ""
	}

	fun validateName(name: String): String = name.toLowerCaseCapitalize()
}

private fun String.toLowerCaseCapitalize(): String =
	StringBuilder(first().uppercase())
		.append(substring(1).lowercase())
		.toString()