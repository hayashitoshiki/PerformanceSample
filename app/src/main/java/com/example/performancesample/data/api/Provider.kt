package com.example.performancesample.data.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import okhttp3.MediaType.Companion.toMediaType

/**
 * API接続先設定
 */
object Provider {

    fun api(): QiitaApiService {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.webServer)
            .client(OkHttpClientBuilder.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(QiitaApiService::class.java)
    }

    @ExperimentalSerializationApi
    fun kotlinSerializationApi(): QiitaApiService {

        val contentType = "application/json".toMediaType()
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.webServer)
            .client(OkHttpClientBuilder.build())
            .addConverterFactory(Json{
                isLenient = true
                ignoreUnknownKeys = true
            }.asConverterFactory(contentType))
            .build()
        return retrofit.create(QiitaApiService::class.java)
    }
}
