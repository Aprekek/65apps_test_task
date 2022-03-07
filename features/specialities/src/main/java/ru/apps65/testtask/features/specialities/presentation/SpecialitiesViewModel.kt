package ru.apps65.testtask.features.specialities.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.apps65.testtask.features.specialities.presentation.states.SpecialitiesState
import ru.apps65.testtask.shared.scenarios.jobinfo.domain.scenario.UpdateJobInfoScenario
import ru.apps65.testtask.shared.speciality.domain.usecases.GetSpecialitiesUseCase
import kotlin.coroutines.CoroutineContext

class SpecialitiesViewModel(
	private val router: SpecialitiesRouter,
	private val getSpecialitiesUseCase: GetSpecialitiesUseCase,
	private val updateJobInfoScenario: UpdateJobInfoScenario
) : ViewModel() {

	private val _state = MutableStateFlow<SpecialitiesState>(SpecialitiesState.Initial)
	val state = _state.asStateFlow()

	private val exceptionHandler = CoroutineExceptionHandler { c: CoroutineContext, throwable: Throwable ->
		Log.d(this::class.qualifiedName, c.toString() + " " + throwable.message.toString())
		_state.value = SpecialitiesState.LoadingError
	}

	init {
		fetchDataAndLoadSpecialities()
	}

	fun reload() {
		viewModelScope.launch(exceptionHandler) {
			val specialities = getSpecialitiesUseCase()
			_state.value = SpecialitiesState.Content(specialities)
		}
	}

	fun onSpecialitySelected(specialityId: Long) {
		router.navigateToEmployeesList(specialityId)
	}

	private fun fetchDataAndLoadSpecialities() {
		viewModelScope.launch(exceptionHandler) {
			updateJobInfoScenario()
			val specialities = getSpecialitiesUseCase()
			_state.value = SpecialitiesState.Content(specialities)
		}
	}
}