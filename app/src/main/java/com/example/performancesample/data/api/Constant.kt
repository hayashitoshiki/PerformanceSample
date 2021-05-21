package com.example.performancesample.data.api

import com.example.performancesample.BuildConfig

class Constant {
    companion object {
        // APIサーバー
        const val webServer: String = BuildConfig.qiitaServer

        // ネットワークタイムアウト
        const val defaultTimeout = 5L
    }
}
