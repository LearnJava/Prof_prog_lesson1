package ru.konstantin.prof_prog_lesson1.data.api

import android.util.Log
import ru.konstantin.prof_prog_lesson1.data.api.ApiConstants.BASE_URL
import ru.konstantin.prof_prog_lesson1.data.model.DataModelResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface TranslatorAPI {
    @GET("words/search")
    fun searchAsync(@Query("search") wordToSearch: String): Deferred<List<DataModelResponse>>

    companion object {

        fun create(): TranslatorAPI =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(TranslatorAPI::class.java)

        private fun createOkHttpClient(): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

        private val httpLoggingInterceptor: HttpLoggingInterceptor
            get() = HttpLoggingInterceptor { message ->
                Log.i("Network", message)
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
    }
}