package ru.apps65.testtask.network.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkProvider {

	const val BASE_URL = "https://gitlab.65apps.com/65gb/static/raw/master/"

	val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
	val retrofit: Retrofit by lazy {
		Retrofit
			.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(MoshiConverterFactory.create(moshi))
			.build()
	}

	inline fun <reified T> createApi(): T = retrofit.create(T::class.java)
}