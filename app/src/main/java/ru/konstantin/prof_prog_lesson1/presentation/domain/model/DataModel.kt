package ru.konstantin.prof_prog_lesson1.presentation.domain.model

data class DataModel(
    val text: String,
    val meanings: List<Meanings>
) {
    companion object {
        fun of(
            text: String?,
            meanings: List<Meanings>
        ): DataModel =
            DataModel(text.orEmpty(), meanings)
    }
}