package ru.apps65.testtask.navigation.routers

import com.github.terrakok.cicerone.Router
import ru.apps65.employees.testtask.features.employees.getEmployeeScreen
import ru.apps65.testtask.features.specialities.presentation.SpecialitiesRouter

class SpecialitiesRouterImpl(
	private val router: Router
) : SpecialitiesRouter {

	override fun navigateToEmployeesList(specialityId: Long) {
		router.navigateTo(getEmployeeScreen(specialityId))
	}
}