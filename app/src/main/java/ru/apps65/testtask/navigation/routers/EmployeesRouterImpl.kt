package ru.apps65.testtask.navigation.routers

import com.github.terrakok.cicerone.Router
import ru.apps65.employees.testtask.features.employees.presentation.EmployeesRouter
import ru.apps65.testtask.features.employees.details.getEmployeeDetailsScreen
import ru.apps65.testtasl.shared.employee.domain.entities.Employee

class EmployeesRouterImpl(
	private val router: Router
) : EmployeesRouter {

	override fun navigateToEmployeeDetails(employee: Employee) {
		router.navigateTo(getEmployeeDetailsScreen(employee))
	}

	override fun navigateExit() {
		router.exit()
	}
}