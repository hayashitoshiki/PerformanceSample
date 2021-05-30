package com.example.performancesample.data.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserByKotlinDto(
    // ユーザID
    val id: String,
    // ユーザ名
    val name: String,
    // 記事の投稿数
    val items_count: String,
    // フォロワー数
    val followees_count: String
)