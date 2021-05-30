package com.example.performancesample.domain.usecase

import com.example.performancesample.data.repositort.QiitaApiRepository
import com.example.performancesample.domain.MyResult
import com.example.qiitalistsample.domain.model.entity.QiitaItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiPerformanceUseCaseImp(private val qiitaApiRepository: QiitaApiRepository) : ApiPerformanceUseCase {

    // Moshiで取得
    override suspend fun getQiitaItemsByMoshi(page: Int): MyResult<List<QiitaItem>> {
        return withContext(Dispatchers.IO) {
            when (val result = qiitaApiRepository.getQiitaItemsByMoshi(page)) {
                is MyResult.Success -> MyResult.Success(result.data)
                is MyResult.Error -> result
            }
        }
    }

    // Kotlin Serializationで取得
    override suspend fun getQiitaItemsByKotlin(page: Int): MyResult<List<QiitaItem>> {
        return withContext(Dispatchers.IO) {
            when (val result = qiitaApiRepository.getQiitaItemsByKotlin(page)) {
                is MyResult.Success -> MyResult.Success(result.data)
                is MyResult.Error -> result
            }
        }
    }
}