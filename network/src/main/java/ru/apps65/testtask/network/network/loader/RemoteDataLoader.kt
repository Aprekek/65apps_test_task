package ru.apps65.testtask.network.network.loader

interface RemoteDataLoader<T> {

	suspend fun getData(path: String): T
}