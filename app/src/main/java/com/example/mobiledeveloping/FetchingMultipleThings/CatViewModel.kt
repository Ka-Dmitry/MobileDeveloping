package com.example.mobiledeveloping.FetchingMultipleThings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiledeveloping.FetchedSingleFact.CatBreed
import kotlinx.coroutines.launch

class CatViewModel : ViewModel() {
    var catFacts by mutableStateOf(listOf<String>())
        private set

    var catBreeds by mutableStateOf(listOf<CatBreed>())
        private set

    fun fetchCatFacts() {
        viewModelScope.launch {
            try {
                val response = RetrofitInst.api.getCatFacts(limit = 5)
                catFacts = response.map { it.fact }
            } catch (e: Exception) {
                catFacts = listOf("Ошибка получения фактов")
            }
        }
    }

    fun fetchCatBreeds(limit: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitInst.api.getCatBreeds(limit = limit) // Запрашиваем породы
                catBreeds = response // Предполагаем, что response уже является List<CatBreed>
            } catch (e: Exception) {
                catBreeds = listOf(CatBreed("Ошибка получения", "Ошибка получения", "Ошибка получения", "Ошибка получения", "Ошибка получения"))
            }
        }
    }
}