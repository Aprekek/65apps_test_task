package ru.apps65.employees.testtask.features.employees

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.apps65.employees.testtask.features.employees.ui.EmployeesFragment

fun getEmployeeScreen(speciality: Long) = FragmentScreen { EmployeesFragment.getInstance(speciality) }