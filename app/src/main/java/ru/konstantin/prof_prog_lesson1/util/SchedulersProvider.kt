package ru.konstantin.prof_prog_lesson1.util

import io.reactivex.rxjava3.core.Scheduler

interface SchedulersProvider {

    fun io() : Scheduler

    fun main() : Scheduler

}