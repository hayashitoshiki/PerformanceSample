package com.example.performancesample.domain.usecase

import com.example.performancesample.domain.MyResult
import com.example.qiitalistsample.data.api.dto.QiitaItemsDto
import com.example.qiitalistsample.data.api.dto.UserDto
import com.example.qiitalistsample.domain.model.entity.QiitaItem

/**
 * APIパフォーマンス計測
 */
interface ApiPerformanceUseCase {

    /**
     * Moshを用いてAPOI取得
     */
    suspend fun getQiitaItemsByMoshi(page: Int) : MyResult<List<QiitaItem>>

    /**
     * Kotlin Serializationを用いてAPOI取得
     */
    suspend fun getQiitaItemsByKotlin(page: Int) : MyResult<List<QiitaItem>>
}