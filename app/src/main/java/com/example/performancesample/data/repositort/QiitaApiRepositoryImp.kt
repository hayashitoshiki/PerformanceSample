package com.example.performancesample.data.repositort

import android.util.Log
import com.example.performancesample.domain.MyResult
import com.example.performancesample.data.api.Provider
import com.example.qiitalistsample.domain.model.entity.QiitaItem
import com.example.qiitalistsample.domain.model.entity.User

class QiitaApiRepositoryImp() : QiitaApiRepository {

    override suspend fun getQiitaItems(page: Int): MyResult<List<QiitaItem>> {
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
    override suspend fun getUserDetails(userId: String): MyResult<User> {
        Log.d("TAG", "ユーザ情報取得 userId = " + userId )
        return runCatching { Provider.api().getUserDetails(userId).execute()}.fold(
            onSuccess = {
                Log.d("TAG", "ユーザ情報取得：success = " + it.body())
                val user = User(it.body()!!.id, it.body()!!.name, it.body()!!.items_count, it.body()!!.followees_count)
                return MyResult.Success(user)
            },
            onFailure = {
                Log.d("TAG", "ユーザ情報取得：onFailure = " + it)
                MyResult.Error(it) }
        )
    }
}