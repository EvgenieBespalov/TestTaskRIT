package com.example.testtaskrit.data.api

import com.example.testtaskrit.data.model.nationalize.NationalizeModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NationalizeApi {
    @GET("https://api.nationalize.io/")
    suspend fun getNationalize(@Query("name[]") names : List<String>): List<NationalizeModel>
}