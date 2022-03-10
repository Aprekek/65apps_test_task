package ru.apps65.employees.testtask.features.employees.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.apps65.employees.testtask.features.employees.domain.usecase.GetEmployeesUseCase
import ru.apps65.employees.testtask.features.employees.presentation.states.EmployeesState
import ru.apps65.testtasl.shared.employee.domain.entities.Employee

class EmployeesViewModel(
	speciality: Long,
	private val router: EmployeesRouter,
	private val getEmployeesUseCase: GetEmployeesUseCase
) : ViewModel() {

	private val _state = MutableStateFlow<EmployeesState>(EmployeesState.Initial)
	val state = _state.asStateFlow()

	private val specialityFilter = listOf(speciality)

	private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
		Log.d(this::class.qualifiedName, throwable.message.toString())
		_state.value = EmployeesState.LoadingError
	}

	init {
		loadEmployees()
	}

	private fun loadEmployees() {
		_state.value = EmployeesState.Loading
		viewModelScope.launch(exceptionHandler) {
			val employees = getEmployeesUseCase(specialityFilter)
			_state.value = EmployeesState.Content(employees).takeIf {
				employees.isNotEmpty()
			} ?: EmployeesState.EmptyContent
		}
	}

	fun reload() {
		loadEmployees()
	}

	fun onEmployeeSelect(employee: Employee) {
		router.navigateToEmployeeDetails(employee)
	}

	fun onExit() {
		router.navigateExit()
	}
}