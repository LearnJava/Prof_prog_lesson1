package ru.konstantin.prof_prog_lesson1.data.mappers

import ru.konstantin.prof_prog_lesson1.data.model.MeaningsResponse
import ru.konstantin.prof_prog_lesson1.domain.model.Meanings

class MeaningsMapper(private val translationMapper: TranslationMapper) {

    private fun toDomain(meaningsResponse: MeaningsResponse): Meanings {

        requireNotNull(meaningsResponse.translation)

        return Meanings.of(
            translationMapper.toDomain(meaningsResponse.translation),
            meaningsResponse.imageUrl,
            meaningsResponse.soundUrl
        )
    }

    fun toDomain(meaningsResponses: List<MeaningsResponse>): List<Meanings> =
        meaningsResponses.map { toDomain(it) }

}