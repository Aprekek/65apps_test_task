package ru.apps65.employees.testtask.features.employees.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.apps65.employees.testtask.features.employees.R
import ru.apps65.employees.testtask.features.employees.databinding.EmployeeItemBinding
import ru.apps65.testtasl.shared.employee.domain.entities.Employee

class EmployeeViewHolder private constructor(
	private val binding: EmployeeItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

	companion object {

		fun from(parent: ViewGroup): EmployeeViewHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = EmployeeItemBinding.inflate(inflater, parent, false)

			return EmployeeViewHolder(binding)
		}
	}

	fun bind(
		employee: Employee,
		onClickAction: (Employee) -> Unit,
		loadImageAction: (view: ImageView, url: String?) -> Unit
	) {
		val context = binding.root.context

		binding.name.text = context.resources.getString(
			R.string.employees_date, employee.firstName, employee.lastName
		)
		binding.date.text = employee.birthday.takeIf { !it.isNullOrBlank() }
			?: context.resources.getString(R.string.empty_date)

		loadImageAction(binding.personImage, employee.avatarUrl)

		binding.root.setOnClickListener {
			onClickAction(employee)
		}
	}
}