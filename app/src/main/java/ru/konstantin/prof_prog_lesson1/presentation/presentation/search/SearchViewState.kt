package ru.konstantin.prof_prog_lesson1.presentation.presentation.search

import ru.konstantin.prof_prog_lesson1.presentation.domain.model.DataModel

sealed class SearchViewState {

    data class Success(val data: List<DataModel>) : SearchViewState()

    data class Error(val error: Throwable) : SearchViewState()

    object Loading : SearchViewState()

    object EmptyResult : SearchViewState()

    object CallToAction : SearchViewState()

}