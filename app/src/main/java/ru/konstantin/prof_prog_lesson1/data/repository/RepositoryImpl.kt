package ru.konstantin.prof_prog_lesson1.data.repository

import ru.konstantin.prof_prog_lesson1.data.api.TranslatorAPI
import ru.konstantin.prof_prog_lesson1.data.mappers.DataModelMapper
import ru.konstantin.prof_prog_lesson1.domain.model.DataModel
import ru.konstantin.prof_prog_lesson1.domain.repository.Repository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


@FlowPreview
class RepositoryImpl(
    private val translatorApi: TranslatorAPI,
    private val dataModelMapper: DataModelMapper
) : Repository<DataModel> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): Flow<List<DataModel>> {
        return if (fromRemoteSource) {
            flowOf(
                translatorApi.searchAsync(word).await()
                    .filter { !it.meanings.isNullOrEmpty() }
                    .map { dataModelMapper.toDomain(it) }
            )
        } else {
            TODO("Room will be here")
        }
    }
}