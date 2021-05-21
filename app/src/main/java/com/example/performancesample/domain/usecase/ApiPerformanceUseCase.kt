package com.example.performancesample.domain.usecase

import com.example.performancesample.domain.MyResult
import com.example.qiitalistsample.data.api.dto.QiitaItemsDto
import com.example.qiitalistsample.data.api.dto.UserDto
import com.example.qiitalistsample.domain.model.entity.QiitaItem

interface ApiPerformanceUseCase {
    suspend fun getQiitaItems(page: Int) : MyResult<List<QiitaItem>>
}