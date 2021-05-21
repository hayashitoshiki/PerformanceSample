package com.example.qiitalistsample.domain.model.entity

import java.io.Serializable

data class QiitaItem(
    // 記事のID
    val id: String,
    // 記事のタイトル
    val title: String,
    // ユーザID
    val userId: String,

   val user: User?,

   var isLiked: Boolean = false
   ) : Serializable