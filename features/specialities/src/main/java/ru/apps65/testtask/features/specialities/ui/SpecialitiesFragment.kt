package ru.apps65.testtask.features.specialities.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.apps65.testtask.features.specialities.databinding.SpecialitiesFragmentBinding
import ru.apps65.testtask.features.specialities.presentation.SpecialitiesViewModel
import ru.apps65.testtask.features.specialities.presentation.states.SpecialitiesState
import ru.apps65.testtask.features.specialities.ui.adapter.SpecialitiesListAdapter
import ru.apps65.testtask.shared.speciality.domain.entities.Speciality
import ru.apps65.testtask.shared.ui.fragments.BaseFragment

class SpecialitiesFragment : BaseFragment<SpecialitiesFragmentBinding>() {

	companion object {

		fun getInstance() = SpecialitiesFragment()
	}

	private val viewModel: SpecialitiesViewModel by viewModel()
	private lateinit var adapter: SpecialitiesListAdapter

	override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
		SpecialitiesFragmentBinding.inflate(inflater, container, false)

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initAdapter()
		initObservers()
	}

	private fun initAdapter() {
		adapter = SpecialitiesListAdapter(viewModel::onSpecialitySelected)
		binding.recyclerView.adapter = adapter
	}

	private fun initObservers() {

		lifecycleScope.launch {
			viewLifecycleOwner.lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
				viewModel.state.collect(::handleState)
			}
		}
	}

	private fun handleState(state: SpecialitiesState) {
		when (state) {
			is SpecialitiesState.Initial,
			is SpecialitiesState.Loading      -> showLoading()
			is SpecialitiesState.Content      -> showContent(state.specialities)
			is SpecialitiesState.LoadingError -> showError()
		}
	}

	private fun showLoading() {
		binding.progressBar.visibility = View.VISIBLE
		binding.recyclerView.visibility = View.GONE
	}

	private fun showContent(specialities: List<Speciality>) {
		binding.progressBar.visibility = View.GONE
		binding.recyclerView.visibility = View.VISIBLE
		adapter.submitList(specialities)
	}

	private fun showError() {

	}
}