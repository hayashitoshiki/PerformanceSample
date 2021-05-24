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
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    init {
        getQiitaItems()
    }

    /**
     * API取得パフォーマンス計測
     */
    fun getQiitaItems() {
        viewModelScope.launch {
            val timeInMillis = measureTimeMillis {
                viewModelScope.launch {
                    apiPerformanceUseCase.getQiitaItemsByMoshi(1)
                }.join()
            }
            _text.value = "Qiita取得時間$timeInMillis"
        }
    }
}