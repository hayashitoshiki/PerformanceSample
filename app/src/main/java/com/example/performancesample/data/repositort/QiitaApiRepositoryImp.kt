package com.example.performancesample.data.repositort

import android.util.Log
import com.example.performancesample.domain.MyResult
import com.example.performancesample.data.api.Provider
import com.example.qiitalistsample.domain.model.entity.QiitaItem
import com.example.qiitalistsample.domain.model.entity.User

class QiitaApiRepositoryImp() : QiitaApiRepository {

    override suspend fun getQiitaItemsByMoshi(page: Int): MyResult<List<QiitaItem>> {
        return runCatching { Provider.api().getItems(page, 50).execute()}.fold(
            onSuccess = {
                Log.d("TAG", "記事取得：success = " + it.body())
                var qiitaItemList = listOf<QiitaItem>()
                it.body()?.let{ qiitaList ->
                    qiitaItemList = qiitaList.map{ dto -> QiitaItem(dto.id, dto.title, dto.user.id, null) }
                }
                MyResult.Success(qiitaItemList)
            },
            onFailure = { MyResult.Error(it) }
        )
    }
}