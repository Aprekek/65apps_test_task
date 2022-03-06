package ru.apps65.testtask.database.data

import android.content.SharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger

class EmployeeKeyGenerator(
	private val sharedPreferences: SharedPreferences
) {

	private companion object {

		const val KEY_TAG = "key_tag"
	}

	private val key = AtomicInteger(0)
	private val scope = CoroutineScope(Job() + Dispatchers.Default)

	fun getNewKey() = key.getAndIncrement()

	init {
		scope.launch {
			restoreLastKeyValue()
		}
	}

	private fun restoreLastKeyValue() {
		key.set(sharedPreferences.getInt(KEY_TAG, 0))
	}

	fun saveKey() {
		sharedPreferences.edit().putInt(KEY_TAG, key.get()).apply()
	}
}