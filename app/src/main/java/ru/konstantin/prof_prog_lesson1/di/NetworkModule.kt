package ru.konstantin.prof_prog_lesson1.di

import ru.konstantin.prof_prog_lesson1.data.api.TranslatorAPI
import dagger.Module
import dagger.Provides


@Module
class NetworkModule {
    @Provides
    fun provideTranslatorAPI(): TranslatorAPI = TranslatorAPI.create()
}