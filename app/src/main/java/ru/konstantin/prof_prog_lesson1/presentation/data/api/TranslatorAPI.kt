package ru.konstantin.prof_prog_lesson1.presentation.data.api

import android.util.Log
import ru.konstantin.prof_prog_lesson1.presentation.data.api.ApiConstants.BASE_URL
import ru.konstantin.prof_prog_lesson1.presentation.data.model.DataModelResponse
import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslatorAPI {
    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Observable<List<DataModelResponse>>

    companion object {
        fun create(): TranslatorAPI =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
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