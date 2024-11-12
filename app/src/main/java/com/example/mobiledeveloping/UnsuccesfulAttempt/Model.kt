package com.example.mobiledeveloping.UnsuccesfulAttempt

import com.google.gson.annotations.SerializedName

data class BreedModel(

    val breed: String,
    val country: String,
    val origin: String,
    val coat: String,
    val pattern: String,

)

data class FactModel(

    val fact: String,
    val length: Int

)

data class BreedList (
    @SerializedName("data")
    val breeds: List<BreedModel>?
)

data class FactsList (
    @SerializedName("data")
    val facts: List<FactModel>?
)
