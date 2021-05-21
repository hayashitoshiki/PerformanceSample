package com.example.performancesample.data.repositort

import com.example.performancesample.domain.MyResult
import com.example.qiitalistsample.domain.model.entity.QiitaItem
import com.example.qiitalistsample.domain.model.entity.User
interface QiitaApiRepository {
    /**
     * 記事取得
     */
    suspend fun getQiitaItems(page: Int) : MyResult<List<QiitaItem>>

    suspend fun getUserDetails(userId: String): MyResult<User>
}