package ru.konstantin.prof_prog_lesson1.application


import android.app.Application
import ru.konstantin.prof_prog_lesson1.di.AppComponent
import ru.konstantin.prof_prog_lesson1.di.DaggerAppComponent

class App : Application() {

    companion object {
        val component: AppComponent by lazy {
            DaggerAppComponent.builder().build()
        }
    }
}