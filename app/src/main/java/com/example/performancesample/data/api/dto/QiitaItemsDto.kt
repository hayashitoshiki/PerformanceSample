package com.example.qiitalistsample.data.api.dto

data class QiitaItemsDto(
    // 記事のID
    val id: String,
    // タイトル
    val title: String,
    // ユーザ情報
    val user: UserDto
)