package com.example.performancesample.data.api

import com.example.qiitalistsample.data.api.dto.QiitaItemsDto
import com.example.qiitalistsample.data.api.dto.UserDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface QiitaApiService {
    @GET("items")
    fun getItems(@Query("page") page: Int,
                 @Query("par_page") perPage: Int): Call<List<QiitaItemsDto>>

}