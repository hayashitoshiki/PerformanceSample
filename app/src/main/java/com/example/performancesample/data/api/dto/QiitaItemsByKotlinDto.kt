package com.example.performancesample.data.api.dto

import com.example.qiitalistsample.data.api.dto.UserDto
import kotlinx.serialization.Serializable

@Serializable
data class QiitaItemsByKotlinDto(
    // 記事のID
    val id: String,
    // タイトル
    val title: String,
    // ユーザ情報
    val user: UserByKotlinDto
)