package ru.konstantin.prof_prog_lesson1.data.mappers

import ru.konstantin.prof_prog_lesson1.data.model.TranslationResponse
import ru.konstantin.prof_prog_lesson1.domain.model.Translation


class TranslationMapper {

    fun toDomain(translationResponse: TranslationResponse): Translation =
        Translation.of(translationResponse.text)
}