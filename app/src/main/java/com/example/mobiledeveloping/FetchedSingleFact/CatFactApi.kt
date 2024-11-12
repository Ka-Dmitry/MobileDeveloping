package com.example.mobiledeveloping.FetchedSingleFact

import retrofit2.Response
import retrofit2.http.GET

interface CatFactApi {
    @GET("fact")
    suspend fun getRandomFact(): Response<CatFact>
}