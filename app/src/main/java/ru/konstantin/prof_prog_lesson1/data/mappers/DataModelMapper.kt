package ru.konstantin.prof_prog_lesson1.data.mappers

import ru.konstantin.prof_prog_lesson1.data.model.DataModelResponse
import ru.konstantin.prof_prog_lesson1.domain.model.DataModel
import javax.inject.Inject


class DataModelMapper @Inject constructor(private val meaningsMapper: MeaningsMapper) {

    private fun toDomain(dataModelResponse: DataModelResponse): DataModel {
        requireNotNull(dataModelResponse.meanings)

        return DataModel.of(
            dataModelResponse.text,
            meaningsMapper.toDomain(dataModelResponse.meanings)
        )
    }

    fun toDomain(dataModelResponse: List<DataModelResponse>): List<DataModel> {
        return dataModelResponse.map { toDomain(it) }
    }
}