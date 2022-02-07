package ru.konstantin.prof_prog_lesson1.domain.repository

import kotlinx.coroutines.flow.Flow


interface Repository<T : Any> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): Flow<List<T>>

}