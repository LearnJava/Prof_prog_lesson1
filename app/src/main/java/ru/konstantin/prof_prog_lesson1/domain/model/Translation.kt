package ru.konstantin.prof_prog_lesson1.domain.model

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