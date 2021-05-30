package com.example.performancesample.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.performancesample.domain.usecase.ApiPerformanceUseCase
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class HomeViewModel(private val apiPerformanceUseCase: ApiPerformanceUseCase) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Moshi 計測中.."
    }
    val text: LiveData<String> = _text
    private val _kotlinText = MutableLiveData<String>().apply {
        value = "Kotlin Serialization 計測中.."
    }
    val kotlinText: LiveData<String> = _kotlinText

    init {
        getQiitaItems()
    }

    /**
     * API取得パフォーマンス計測
     */
    fun getQiitaItems() {
        viewModelScope.launch {
            val timeInMillis1 = measureTimeMillis {
                viewModelScope.launch {
                    apiPerformanceUseCase.getQiitaItemsByMoshi(1)
                }.join()
            }
            _text.value = "Qiita取得時間(moshi)$timeInMillis1"

            val timeInMillis2 = measureTimeMillis {
                viewModelScope.launch {
                    apiPerformanceUseCase.getQiitaItemsByKotlin(1)
                }.join()
            }
            _kotlinText.value = "Qiita取得時間(kotlin)$timeInMillis2"
        }
    }
}