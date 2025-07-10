package com.example.myapplication.di

import com.example.myapplication.FeatureService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object FeatureModule {
    private const val JSON_MIME_TYPE = "application/json; charset=UTF8"

    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    fun providesFeatureService(okHttpClient: OkHttpClient): FeatureService =
        Retrofit.Builder()
            .baseUrl(FeatureService.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(
                Json { ignoreUnknownKeys = true }.asConverterFactory(
                    JSON_MIME_TYPE.toMediaType(),
                ),
            )
            .build()
            .create(FeatureService::class.java)
}
