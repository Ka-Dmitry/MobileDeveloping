package com.example.mobiledeveloping.UnsuccesfulAttempt

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val url = "https://catfact.ninja"

suspend fun getAllBreeds() : BreedList? {

    var breedLt: BreedList? = null

    val api = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SimpleApi::class.java)

    api.getBreeds().enqueue(object : Callback<BreedList> {

        override fun onResponse(call: Call<BreedList>, response: Response<BreedList>) {
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.i("CHECK_RESPONSE_BREED", "onResponse: ${it.breeds}")
                    Log.i("CHECK_RESPONSE_BREED", "onResponse: ${it.breeds?.get(0)?.breed}")
                    breedLt = it
                }
            }
        }

        override fun onFailure(call: Call<BreedList>, t: Throwable) {
            Log.i("CHECK_RESPONSE_BREED", "onFailure: ${t.message}")
        }
    })

    return breedLt

}

suspend fun getAllFacts() {

    val api = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SimpleApi::class.java)

    api.getFacts().enqueue(object : Callback<FactsList> {

        override fun onResponse(call: Call<FactsList>, response: Response<FactsList>) {
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.i("CHECK_RESPONSE_FACTS", "OnResponse: ${it.facts}")
                }
            }
        }

        override fun onFailure(call: Call<FactsList>, t: Throwable) {
            Log.i("CHECK_RESPONSE_FACTS", "onFailure: ${t.message}")
        }
    })

}
