package ru.konstantin.prof_prog_lesson1.di

import kotlinx.coroutines.FlowPreview
import ru.konstantin.prof_prog_lesson1.data.api.TranslatorAPI
import ru.konstantin.prof_prog_lesson1.data.mappers.DataModelMapper
import ru.konstantin.prof_prog_lesson1.data.mappers.MeaningsMapper
import ru.konstantin.prof_prog_lesson1.data.mappers.TranslationMapper
import ru.konstantin.prof_prog_lesson1.data.repository.RepositoryImpl
import ru.konstantin.prof_prog_lesson1.domain.model.DataModel
import ru.konstantin.prof_prog_lesson1.domain.repository.Repository
import ru.konstantin.prof_prog_lesson1.presentation.search.SearchViewModel
import ru.konstantin.prof_prog_lesson1.util.DefaultDispatcherProvider
import ru.konstantin.prof_prog_lesson1.util.DispatcherProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@FlowPreview
val application = module {

    factory { TranslationMapper() }
    factory { MeaningsMapper(get()) }
    factory { DataModelMapper(get()) }
    single { TranslatorAPI.create() }
    single<Repository<DataModel>> { RepositoryImpl(get(), get()) }
    factory<DispatcherProvider> { DefaultDispatcherProvider() }
}

val searchScreen = module {

    viewModel { SearchViewModel(get(), get()) }
}