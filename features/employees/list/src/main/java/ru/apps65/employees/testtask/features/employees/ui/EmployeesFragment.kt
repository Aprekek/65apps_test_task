package ru.apps65.employees.testtask.features.employees.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.apps65.employees.testtask.features.employees.databinding.EmployeesFragmentBinding
import ru.apps65.employees.testtask.features.employees.presentation.EmployeesViewModel
import ru.apps65.employees.testtask.features.employees.presentation.states.EmployeesState
import ru.apps65.employees.testtask.features.employees.ui.adapter.EmployeesAdapter
import ru.apps65.testtask.shared.ui.databinding.ErrorLayoutBinding
import ru.apps65.testtask.shared.ui.fragments.BaseFragment
import ru.apps65.testtasl.shared.employee.domain.entities.Employee

private const val SPECIALITY_KEY = "SPECIALITY_KEY"
private var Bundle.specialityArg
	get() = getLong(SPECIALITY_KEY)
	set(value) = putLong(SPECIALITY_KEY, value)

class EmployeesFragment : BaseFragment<EmployeesFragmentBinding>() {

	companion object {

		fun getInstance(speciality: Long) = EmployeesFragment().apply {
			arguments = Bundle().apply { specialityArg = speciality }
		}
	}

	private val viewModel: EmployeesViewModel by viewModel {
		parametersOf(requireArguments().specialityArg)
	}
	private lateinit var adapter: EmployeesAdapter

	private var errorMessageBinding: ErrorLayoutBinding? = null

	override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): EmployeesFragmentBinding =
		EmployeesFragmentBinding.inflate(inflater, container, false)

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		initAdapter()
		initObservers()
		initListeners()
	}

	private fun initAdapter() {
		adapter = EmployeesAdapter(::loadImageForItem, viewModel::onEmployeeSelect)
		binding.recyclerView.adapter = adapter
	}

	private fun initObservers() {
		lifecycleScope.launch {
			viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
				viewModel.state.collect(::handleState)
			}
		}
	}

	private fun initListeners() {
		binding.backButton.setOnClickListener {
			viewModel.onExit()
		}
	}

	private fun handleState(state: EmployeesState) {
		when (state) {
			is EmployeesState.Initial,
			is EmployeesState.Loading      -> showLoading()
			is EmployeesState.Content      -> showContent(state.employees)
			is EmployeesState.LoadingError -> showError()
			is EmployeesState.EmptyContent -> showEmptyMessage()
		}
	}

	private fun showLoading() {
		binding.progressBar.visibility = View.VISIBLE
		binding.recyclerView.visibility = View.GONE
		errorMessageBinding?.root?.visibility = View.GONE
	}

	private fun showContent(employees: List<Employee>) {
		binding.progressBar.visibility = View.GONE
		binding.recyclerView.visibility = View.VISIBLE
		adapter.submitList(employees)
	}

	private fun showError() {
		binding.progressBar.visibility = View.GONE
		showErrorMessage()
	}

	private fun showErrorMessage() {
		if (errorMessageBinding == null) {
			inflateErrorMessage()
		}
		errorMessageBinding?.root?.visibility = View.VISIBLE
	}

	private fun inflateErrorMessage() {
		errorMessageBinding = ErrorLayoutBinding.bind(
			binding.errorMessageStub.inflate()
		)
		errorMessageBinding?.reloadButton?.setOnClickListener {
			viewModel.reload()
		}
	}

	private fun showEmptyMessage() {
		binding.progressBar.visibility = View.GONE
		binding.emptyListMessage.visibility = View.VISIBLE
	}

	private fun loadImageForItem(view: ImageView, url: String?) {
		Glide.with(this)
			.load(url)
			.placeholder(ru.apps65.testtask.themes.R.drawable.ic_person)
			.centerCrop()
			.into(view)
	}

	override fun onDestroy() {
		errorMessageBinding = null
		super.onDestroy()
	}
}