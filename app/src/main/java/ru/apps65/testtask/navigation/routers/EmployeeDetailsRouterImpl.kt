package ru.apps65.testtask.navigation.routers

import com.github.terrakok.cicerone.Router
import ru.apps65.testtask.features.employees.details.presentation.EmployeeDetailsRouter

class EmployeeDetailsRouterImpl(
	private val router: Router
) : EmployeeDetailsRouter {

	override fun navigateExit() {
		router.exit()
	}
}