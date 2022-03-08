package ru.apps65.testtask.features.employees.details.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.apps65.testtask.features.employees.details.presentation.EmployeeDetailsViewModel
import ru.apps65.testtasl.shared.employee.domain.entities.Employee

val employeeDetailsModule = module {
	viewModel { (employee: Employee) ->
		EmployeeDetailsViewModel(
			employee = employee,
			router = get()
		)
	}
}