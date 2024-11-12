package com.example.mobiledeveloping.FetchingMultipleThings

import com.example.mobiledeveloping.FetchedSingleFact.CatBreed
import com.example.mobiledeveloping.FetchedSingleFact.CatFact
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("facts")
    suspend fun getCatFacts(@Query("limit") limit: Int): List<CatFact>

    @GET("breeds")
    suspend fun getCatBreeds(@Query("limit") limit: Int): List<CatBreed>
}