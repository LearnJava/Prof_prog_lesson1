package ru.konstantin.prof_prog_lesson1.presentation.data.repository

import ru.konstantin.prof_prog_lesson1.presentation.data.api.TranslatorAPI
import ru.konstantin.prof_prog_lesson1.presentation.data.mappers.DataModelMapper
import ru.konstantin.prof_prog_lesson1.presentation.domain.model.DataModel
import ru.konstantin.prof_prog_lesson1.presentation.domain.repositories.Repository
import io.reactivex.rxjava3.core.Observable

class RepositoryImpl(

    private val translatorAPI: TranslatorAPI,
    private val dataModelMapper: DataModelMapper
) : Repository<DataModel> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<List<DataModel>> {
        return if (fromRemoteSource) {
            translatorAPI.search(word)
                .flatMap { Observable.fromIterable(it) }
                .filter { !it.meanings.isNullOrEmpty() }
                .toList()
                .map { dataModelMapper.toDomain(it) }
                .flatMapObservable { Observable.just(it) }
        } else {
            TODO("wait db")
        }
    }
}