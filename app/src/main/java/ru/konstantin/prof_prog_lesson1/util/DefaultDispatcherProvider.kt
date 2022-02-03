package ru.konstantin.prof_prog_lesson1.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DefaultDispatcherProvider : DispatcherProvider {

    override fun io(): CoroutineDispatcher = Dispatchers.IO

    override fun main(): CoroutineDispatcher = Dispatchers.Main

}