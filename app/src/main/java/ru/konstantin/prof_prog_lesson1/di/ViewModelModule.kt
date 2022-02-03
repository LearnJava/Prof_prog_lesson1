package ru.konstantin.prof_prog_lesson1.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.konstantin.prof_prog_lesson1.presentation.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel
}