package com.example.testtaskrit.data.api

import com.example.testtaskrit.data.model.dog.DogModel
import retrofit2.http.GET

interface DogApi {
    @GET("https://dog.ceo/api/breeds/image/random")
    suspend fun getRandomDog(): DogModel
}