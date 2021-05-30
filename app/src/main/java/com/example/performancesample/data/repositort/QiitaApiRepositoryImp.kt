package com.example.performancesample.data.repositort

import android.util.Log
import com.example.performancesample.domain.MyResult
import com.example.performancesample.data.api.Provider
import com.example.qiitalistsample.domain.model.entity.QiitaItem
import kotlinx.serialization.ExperimentalSerializationApi

class QiitaApiRepositoryImp() : QiitaApiRepository {

    override suspend fun getQiitaItemsByMoshi(page: Int): MyResult<List<QiitaItem>> {
        return runCatching { Provider.api().getItemsByMoshi(page, 150).execute()}.fold(
            onSuccess = {
                Log.d("QiitaApiRepositoryImp", "moshi..記事取得：success = " + it.body())
                var qiitaItemList = listOf<QiitaItem>()
                it.body()?.let{ qiitaList ->
                    qiitaItemList = qiitaList.map{ dto -> QiitaItem(dto.id, dto.title, dto.user.id, null) }
                }
                MyResult.Success(qiitaItemList)
            },
            onFailure = {
                Log.d("QiitaApiRepositoryImp", "moshi..記事取得：Failure = $it")
                MyResult.Error(it)
            }
        )
    }

    @ExperimentalSerializationApi
    override suspend fun getQiitaItemsByKotlin(page: Int): MyResult<List<QiitaItem>> {
        return runCatching { Provider.kotlinSerializationApi().getItemsByKotlin(page, 150).execute()}.fold(
            onSuccess = {
                Log.d("QiitaApiRepositoryImp", "kotlin.記事取得：success = " + it.body())
                var qiitaItemList = listOf<QiitaItem>()
                it.body()?.let{ qiitaList ->
                    qiitaItemList = qiitaList.map{ dto -> QiitaItem(dto.id, dto.title, dto.user.id, null) }
                }
                MyResult.Success(qiitaItemList)
            },
            onFailure = {
                Log.d("QiitaApiRepositoryImp", "kotlin.記事取得：Failure = $it")
                MyResult.Error(it)
            }
        )
    }
}