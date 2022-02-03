package ru.konstantin.prof_prog_lesson1.di

import ru.konstantin.prof_prog_lesson1.presentation.search.SearchFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        MappersModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        RxModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    interface Builder {

        fun build(): AppComponent

    }

    fun inject(searchFragment: SearchFragment)

}