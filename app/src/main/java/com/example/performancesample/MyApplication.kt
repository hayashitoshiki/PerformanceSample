package com.example.performancesample

import android.app.Application
import android.util.Log
import com.example.performancesample.data.repositort.QiitaApiRepository
import com.example.performancesample.data.repositort.QiitaApiRepositoryImp
import com.example.performancesample.domain.usecase.ApiPerformanceUseCase
import com.example.performancesample.domain.usecase.ApiPerformanceUseCaseImp
import com.example.performancesample.ui.dashboard.DashboardViewModel
import com.example.performancesample.ui.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class MyApplication : Application() {
    companion object {
        lateinit var shared: MyApplication

        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val TAG = javaClass.name
    }
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")

        startKoin {
            androidContext(applicationContext)
            modules(module)
        }
    }

    // Koinモジュール
    private val module: Module = module {

        viewModel { HomeViewModel(get()) }
        viewModel { DashboardViewModel() }

        factory <ApiPerformanceUseCase> { ApiPerformanceUseCaseImp(get()) }

        factory <QiitaApiRepository> { QiitaApiRepositoryImp() }
    }
}