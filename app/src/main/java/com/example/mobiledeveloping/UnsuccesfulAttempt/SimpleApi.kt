package com.example.mobiledeveloping.UnsuccesfulAttempt

import retrofit2.Call
import retrofit2.http.GET

interface SimpleApi {

    @GET("/breeds")
    fun getBreeds(): Call<BreedList>

    @GET("/facts")
    fun getFacts(): Call<FactsList>

}