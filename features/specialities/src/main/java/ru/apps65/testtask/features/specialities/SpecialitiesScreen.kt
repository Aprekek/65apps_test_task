package ru.apps65.testtask.features.specialities

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.apps65.testtask.features.specialities.ui.SpecialitiesFragment

fun getSpecialitiesScreen() = FragmentScreen { SpecialitiesFragment.getInstance() }