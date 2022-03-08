package ru.apps65.testtask.features.employees.details.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.apps65.testtask.features.employees.details.presentation.states.EmployeeDetailsState
import ru.apps65.testtasl.shared.employee.domain.entities.Employee
import java.text.SimpleDateFormat
import java.util.*

class EmployeeDetailsViewModel(
	employee: Employee,
	private val router: EmployeeDetailsRouter
) : ViewModel() {

	private val _state = MutableStateFlow<EmployeeDetailsState>(
		EmployeeDetailsState.Content(employee, getAge(employee.birthday))
	)
	val state = _state.asStateFlow()

	fun onExit() {
		router.navigateExit()
	}

	private fun getAge(date: String?): Int? {
		if (date.isNullOrBlank())
			return null

		val (curDay, curMoth, curYear) = SimpleDateFormat("dd.MM.yyyy", Locale("ru"))
			.format(Date())
			.split(".")
			.map { it.toInt() }

		val (birthDay, birthMoth, birthYear) = date.split(".").map { it.toInt() }

		var age = curYear - birthYear
		if (birthMoth < curYear || birthDay == curMoth && birthDay < curDay) {
			age--
		}

		return age
	}
}