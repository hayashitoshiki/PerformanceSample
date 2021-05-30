package com.example.performancesample.data.api

import com.example.performancesample.data.api.dto.QiitaItemsByKotlinDto
import com.example.qiitalistsample.data.api.dto.QiitaItemsDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QiitaApiService {

    @GET("items")
    fun getItemsByMoshi(@Query("page") page: Int,
                 @Query("par_page") perPage: Int): Call<List<QiitaItemsDto>>

    @GET("items")
    fun getItemsByKotlin(@Query("page") page: Int,
                 @Query("par_page") perPage: Int): Call<List<QiitaItemsByKotlinDto>>

}