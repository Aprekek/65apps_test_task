package ru.apps65.testtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.NavigatorHolder
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import ru.apps65.testtask.database.data.EmployeeKeyGenerator
import ru.apps65.testtask.navigation.routers.AnimatedAppNavigator

class MainActivity : AppCompatActivity() {

	private val navigatorHolder: NavigatorHolder by inject()
	private val navigator = AnimatedAppNavigator(this, R.id.container)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	override fun onResume() {
		super.onResume()
		navigatorHolder.setNavigator(navigator)
	}

	override fun onPause() {
		super.onPause()
		navigatorHolder.removeNavigator()
		get<EmployeeKeyGenerator>().saveKey()
	}
}