package ru.apps65.employees.testtask.features.employees.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.apps65.testtasl.shared.employee.domain.entities.Employee

class EmployeesAdapter(
	private val context: Context,
	private val onItemClickAction: (Employee) -> Unit
) : ListAdapter<Employee, EmployeeViewHolder>(EmployeeDiffUtil) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder =
		EmployeeViewHolder.from(parent, context)

	override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
		holder.bind(getItem(position), onItemClickAction)
	}
}

private object EmployeeDiffUtil : DiffUtil.ItemCallback<Employee>() {

	override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean =
		oldItem.id == newItem.id

	override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean =
		oldItem == newItem
}