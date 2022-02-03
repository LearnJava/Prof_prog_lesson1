package ru.konstantin.prof_prog_lesson1.domain.repositories

import ru.konstantin.prof_prog_lesson1.domain.model.DataModel
import io.reactivex.rxjava3.core.Single

interface Repository<T : Any> {
    fun getData(word: String, fromRemoteSource: Boolean): Single<List<DataModel>>
}