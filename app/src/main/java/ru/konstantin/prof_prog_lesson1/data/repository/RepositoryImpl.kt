package ru.konstantin.prof_prog_lesson1.data.repository

import ru.konstantin.prof_prog_lesson1.data.api.TranslatorAPI
import ru.konstantin.prof_prog_lesson1.data.mappers.DataModelMapper
import ru.konstantin.prof_prog_lesson1.domain.model.DataModel
import ru.konstantin.prof_prog_lesson1.domain.repositories.Repository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val translatorAPI: TranslatorAPI,
    private val dataModelMapper: DataModelMapper
) : Repository<DataModel> {

    override fun getData(word: String, fromRemoteSource: Boolean):  Single<List<DataModel>> {
        return if (fromRemoteSource) {
            translatorAPI.search(word)
                .flatMapObservable { Observable.fromIterable(it) }
                .filter { !it.meanings.isNullOrEmpty() }
                .toList()
                .map { dataModelMapper.toDomain(it) }
        } else {
            TODO("wait db")
        }
    }
}