package com.example.mobiledeveloping.FetchedSingleFact

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CatFactViewModel : ViewModel() {
    var catFact by mutableStateOf("Загрузка...")
        private set

    fun fetchCatFact() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getRandomFact()
                catFact = response.body()?.fact.toString()
                Log.i("CHECK_RESPONSE_SUCCESS", "Got: ${response.body()}")
            } catch (e: Exception) {
                catFact = "Ошибка получения факта"
                Log.i("CHECK_RESPONSE_FAILURE", "Error")
            }
        }
    }


}