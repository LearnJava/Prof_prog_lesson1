package ru.konstantin.prof_prog_lesson1.data.mappers

import ru.konstantin.prof_prog_lesson1.data.model.DataModelResponse
import ru.konstantin.prof_prog_lesson1.domain.model.DataModel


class DataModelMapper(private val meaningsMapper: MeaningsMapper) {

    fun toDomain(dataModelResponse: DataModelResponse): DataModel {

        requireNotNull(dataModelResponse.meanings)

        return DataModel.of(
            dataModelResponse.text,
            meaningsMapper.toDomain(dataModelResponse.meanings)
        )
    }
}