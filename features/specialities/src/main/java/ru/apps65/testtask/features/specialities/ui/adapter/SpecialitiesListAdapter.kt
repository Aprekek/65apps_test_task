package ru.apps65.testtask.features.specialities.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.apps65.testtask.shared.speciality.domain.entities.Speciality

class SpecialitiesListAdapter(
	private val onItemClickAction: (Long) -> Unit
) : ListAdapter<Speciality, SpecialityViewHolder>(SpecialityDiffUtil) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialityViewHolder =
		SpecialityViewHolder.from(parent)

	override fun onBindViewHolder(holder: SpecialityViewHolder, position: Int) {
		holder.bind(getItem(position), onItemClickAction)
	}
}

private object SpecialityDiffUtil : DiffUtil.ItemCallback<Speciality>() {

	override fun areItemsTheSame(oldItem: Speciality, newItem: Speciality): Boolean =
		oldItem.id == newItem.id

	override fun areContentsTheSame(oldItem: Speciality, newItem: Speciality): Boolean =
		oldItem == newItem
}