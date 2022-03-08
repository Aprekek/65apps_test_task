package ru.apps65.testtask.features.employees.details

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.apps65.testtask.features.employees.details.ui.EmployeeDetailsFragment
import ru.apps65.testtasl.shared.employee.domain.entities.Employee

fun getEmployeeDetailsScreen(employee: Employee) = FragmentScreen { EmployeeDetailsFragment.getInstance(employee) }