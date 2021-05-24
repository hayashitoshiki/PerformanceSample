package com.example.performancesample.data.repositort

import com.example.performancesample.domain.MyResult
import com.example.qiitalistsample.domain.model.entity.QiitaItem
import com.example.qiitalistsample.domain.model.entity.User
interface QiitaApiRepository {
    /**
     * Moshiを用いて記事取得
     */
    suspend fun getQiitaItemsByMoshi(page: Int) : MyResult<List<QiitaItem>>
}