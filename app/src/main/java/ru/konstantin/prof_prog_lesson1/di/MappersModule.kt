package ru.konstantin.prof_prog_lesson1.di

import ru.konstantin.prof_prog_lesson1.data.mappers.DataModelMapper
import ru.konstantin.prof_prog_lesson1.data.mappers.MeaningsMapper
import ru.konstantin.prof_prog_lesson1.data.mappers.TranslationMapper
import dagger.Module
import dagger.Provides

@Module
class MappersModule {

    @Provides
    fun provideTranslationMapper(): TranslationMapper = TranslationMapper()

    @Provides
    fun provideMeaningsMapper(translationMapper: TranslationMapper): MeaningsMapper =
        MeaningsMapper(translationMapper)

    @Provides
    fun provideDataModelMapper(meaningsMapper: MeaningsMapper): DataModelMapper =
        DataModelMapper(meaningsMapper)

}