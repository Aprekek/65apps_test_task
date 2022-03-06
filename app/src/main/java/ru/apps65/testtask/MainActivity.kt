package ru.apps65.testtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.get
import ru.apps65.testtask.database.data.EmployeeKeyGenerator

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	override fun onPause() {
		super.onPause()
		get<EmployeeKeyGenerator>().saveKey()
	}
}