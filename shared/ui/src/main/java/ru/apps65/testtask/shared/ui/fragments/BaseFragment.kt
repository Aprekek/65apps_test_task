package ru.apps65.testtask.shared.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding> : Fragment() {

	private var _binding: T? = null
	val binding: T
		get() = _binding ?: throw IllegalStateException("Binding must be not null")

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		_binding = getBinding(inflater, container)
		return binding.root
	}

	abstract fun getBinding(inflater: LayoutInflater, container: ViewGroup?): T

	override fun onDestroy() {
		_binding = null
		super.onDestroy()
	}
}