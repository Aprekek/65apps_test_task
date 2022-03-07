package ru.apps65.testtask.features.specialities.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.apps65.testtask.features.specialities.databinding.SpecialityItemBinding
import ru.apps65.testtask.shared.speciality.domain.entities.Speciality

class SpecialityViewHolder private constructor(
	private val binding: SpecialityItemBinding
) : RecyclerView.ViewHolder(binding.root) {

	companion object {

		fun from(parent: ViewGroup): SpecialityViewHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = SpecialityItemBinding.inflate(inflater, parent, false)

			return SpecialityViewHolder(binding)
		}
	}

	fun bind(speciality: Speciality, onClickAction: (Long) -> Unit) {
		binding.specialityId.text = speciality.name
		binding.root.setOnClickListener {
			onClickAction(speciality.id)
		}
	}
}