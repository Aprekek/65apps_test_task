package ru.apps65.testtask.features.employees.details.ui

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.apps65.testtask.features.employees.details.R
import ru.apps65.testtask.features.employees.details.databinding.EmployeeDetailsFragmentBinding
import ru.apps65.testtask.features.employees.details.presentation.EmployeeDetailsViewModel
import ru.apps65.testtask.features.employees.details.presentation.states.EmployeeDetailsState
import ru.apps65.testtask.shared.ui.fragments.BaseFragment
import ru.apps65.testtasl.shared.employee.domain.entities.Employee

private const val EMPLOYEE_KEY = "EMPLOYEE_KEY"
private var Bundle.employeeArg
	get() = getSerializable(EMPLOYEE_KEY) as Employee
	set(value) = putSerializable(EMPLOYEE_KEY, value)

class EmployeeDetailsFragment : BaseFragment<EmployeeDetailsFragmentBinding>() {

	companion object {

		fun getInstance(employee: Employee) = EmployeeDetailsFragment().apply {
			arguments = Bundle().apply {
				employeeArg = employee
			}
		}
	}

	private val viewModel: EmployeeDetailsViewModel by viewModel {
		parametersOf(requireArguments().employeeArg)
	}

	override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): EmployeeDetailsFragmentBinding =
		EmployeeDetailsFragmentBinding.inflate(inflater, container, false)

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initObservers()
		initListeners()
	}

	private fun initObservers() {
		lifecycleScope.launch {
			viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
				viewModel.state.collect(::handleState)
			}
		}
	}

	private fun handleState(state: EmployeeDetailsState) {
		when (state) {
			is EmployeeDetailsState.Content -> showContent(state)
		}
	}

	private fun showContent(state: EmployeeDetailsState.Content) {
		val employee = state.employee
		val age = state.age
		val spannableBuilder = SpannableStringBuilder()

		Glide.with(this)
			.load(employee.avatarUrl)
			.placeholder(ru.apps65.testtask.themes.R.drawable.ic_person)
			.into(binding.personImage)

		binding.fullName.text = resources.getString(R.string.full_name, employee.firstName, employee.lastName)

		binding.date.text = spannableBuilder.appendBold(
			resources.getString(R.string.birth_date) + " "
		).append(employee.birthday.takeIf { !it.isNullOrBlank() } ?: resources.getString(R.string.empty_date))
		spannableBuilder.clear()

		binding.age.text = spannableBuilder.appendBold(
			resources.getString(R.string.age) + " "
		).append(age?.toString() ?: resources.getString(R.string.empty_date))
		spannableBuilder.clear()

		binding.speciality.text = spannableBuilder.appendBold(
			resources.getString(R.string.speciality) + " "
		).apply {
			append(employee.speciality.first().name)
			for (i in 1 until employee.speciality.size) {
				append(", " + employee.speciality[i].name)
			}
		}
	}

	private fun initListeners() {
		binding.backButton.setOnClickListener {
			viewModel.onExit()
		}
	}
}

fun SpannableStringBuilder.appendBold(string: String) = apply {
	val startIndex = length
	append(string)
	setSpan(StyleSpan(Typeface.BOLD), startIndex, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
}