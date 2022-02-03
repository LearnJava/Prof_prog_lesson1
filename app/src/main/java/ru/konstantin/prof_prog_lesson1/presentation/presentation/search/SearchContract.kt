package ru.konstantin.prof_prog_lesson1.presentation.presentation.search

interface SearchContract {

    interface View {

        fun renderData(viewState: SearchViewState)

    }

    interface Presenter<V : View> {

        fun attachView(view: SearchFragment)

        fun detachView()

        fun getData(word: String, isOnline: Boolean)

    }

}