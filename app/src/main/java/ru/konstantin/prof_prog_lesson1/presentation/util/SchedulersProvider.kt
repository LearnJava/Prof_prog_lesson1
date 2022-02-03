package ru.konstantin.prof_prog_lesson1.presentation.util

import io.reactivex.rxjava3.core.Scheduler

interface SchedulersProvider {

    fun io() : Scheduler

    fun main() : Scheduler

}