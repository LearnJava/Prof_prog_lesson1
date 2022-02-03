package ru.konstantin.prof_prog_lesson1.di

import ru.konstantin.prof_prog_lesson1.util.SchedulersProvider
import ru.konstantin.prof_prog_lesson1.util.SchedulersProviderImplementation
import dagger.Module
import dagger.Provides

@Module
class RxModule {

    @Provides
    fun provideSchedulersProvider(): SchedulersProvider =
        SchedulersProviderImplementation()
}