package ru.konstantin.prof_prog_lesson1.presentation.domain.repositories

import io.reactivex.rxjava3.core.Observable

interface Repository<T : Any> {
    fun getData(word: String, fromRemoteSource: Boolean): Observable<List<T>>
}