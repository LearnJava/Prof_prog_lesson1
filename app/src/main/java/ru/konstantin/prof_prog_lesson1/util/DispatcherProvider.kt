package ru.konstantin.prof_prog_lesson1.util

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {

    fun io(): CoroutineDispatcher

    fun main(): CoroutineDispatcher

}