package com.example.mobiledeveloping.FetchingMultipleThings

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInst {
    private const val BASE_URL = "https://catfact.ninja/"

    val api: CatApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatApi::class.java)
    }
}