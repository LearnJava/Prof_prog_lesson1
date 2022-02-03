package ru.konstantin.prof_prog_lesson1.presentation.data.mappers

import ru.konstantin.prof_prog_lesson1.presentation.data.model.TranslationResponse
import ru.konstantin.prof_prog_lesson1.presentation.domain.model.Translation


class TranslationMapper {

    fun toDomain(translationResponse: TranslationResponse): Translation =
        Translation.of(translationResponse.text)
}