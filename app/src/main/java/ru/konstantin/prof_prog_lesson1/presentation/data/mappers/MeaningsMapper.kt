package ru.konstantin.prof_prog_lesson1.presentation.data.mappers

import ru.konstantin.prof_prog_lesson1.presentation.data.model.MeaningsResponse
import ru.konstantin.prof_prog_lesson1.presentation.domain.model.Meanings

class MeaningsMapper {
    private val translationMapper = TranslationMapper()

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