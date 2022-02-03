package ru.konstantin.prof_prog_lesson1.presentation.domain.model

data class Translation(
    val text: String
) {
    companion object {
        fun of(
            text: String?
        ): Translation =
            Translation(text.orEmpty())
    }
}