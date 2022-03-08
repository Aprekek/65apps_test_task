package ru.apps65.employees.testtask.features.employees.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.apps65.employees.testtask.features.employees.R
import ru.apps65.employees.testtask.features.employees.databinding.EmployeeItemBinding
import ru.apps65.testtasl.shared.employee.domain.entities.Employee

class EmployeeViewHolder private constructor(
	private val binding: EmployeeItemBinding,
	private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

	companion object {

		fun from(parent: ViewGroup, context: Context): EmployeeViewHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = EmployeeItemBinding.inflate(inflater, parent, false)

			return EmployeeViewHolder(binding, context)
		}
	}

	fun bind(employee: Employee, onClickAction: (Employee) -> Unit) {
		binding.name.text = context.resources.getString(
			R.string.employees_date, employee.firstName, employee.lastName
		)
		binding.date.text = employee.birthday.takeIf { !it.isNullOrBlank() }
			?: context.resources.getString(R.string.empty_date)

		Glide.with(context)
			.load(employee.avatarUrl)
			.placeholder(ru.apps65.testtask.themes.R.drawable.ic_person)
			.centerCrop()
			.into(binding.personImage)

		binding.root.setOnClickListener {
			onClickAction(employee)
		}
	}
}