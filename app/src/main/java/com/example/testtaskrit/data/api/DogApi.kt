package com.example.testtaskrit.data.api

import com.example.testtaskrit.data.model.dog.DogModel
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {
    @GET("random")
    suspend fun getRandomDog(): DogModel
}