package ru.apps65.testtask.network.network.loader

import com.squareup.moshi.JsonAdapter
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.nio.charset.Charset
import javax.net.ssl.HttpsURLConnection

class LegacyRemoteDataLoader<T>(
	private val jsonAdapter: JsonAdapter<T>
) : RemoteDataLoader<T> {

	override suspend fun getData(path: String): T {
		var connection: HttpsURLConnection? = null
		try {
			connection = URL(path).openConnection() as HttpsURLConnection
			val reader = BufferedReader(
				InputStreamReader(
					connection.inputStream,
					Charset.forName("UTF-8")
				)
			)
			val responseJsonBuilder = StringBuilder()
			reader.forEachLine(responseJsonBuilder::append)

			return jsonAdapter.fromJson(responseJsonBuilder.toString())
				?: throw NullPointerException("JSON document was not parsed into model")

		} catch (e: Exception) {
			throw e
		} finally {
			connection?.disconnect()
		}
	}
}