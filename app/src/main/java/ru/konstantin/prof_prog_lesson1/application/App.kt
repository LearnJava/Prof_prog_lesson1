package ru.konstantin.prof_prog_lesson1.application


import android.app.Application
import ru.konstantin.prof_prog_lesson1.di.application
import ru.konstantin.prof_prog_lesson1.di.searchScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        org.koin.core.context.startKoin {
            androidContext(this@App)
            modules(listOf(application, searchScreen))
        }
    }
}