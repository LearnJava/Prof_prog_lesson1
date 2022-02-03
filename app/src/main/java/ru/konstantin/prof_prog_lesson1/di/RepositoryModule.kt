package ru.konstantin.prof_prog_lesson1.di

import ru.konstantin.prof_prog_lesson1.data.api.TranslatorAPI
import ru.konstantin.prof_prog_lesson1.data.mappers.DataModelMapper
import ru.konstantin.prof_prog_lesson1.data.repository.RepositoryImpl
import ru.konstantin.prof_prog_lesson1.domain.model.DataModel
import ru.konstantin.prof_prog_lesson1.domain.repositories.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        translatorAPI: TranslatorAPI,
        dataModelMapper: DataModelMapper
    ): Repository<DataModel> =
        RepositoryImpl(translatorAPI, dataModelMapper)
}