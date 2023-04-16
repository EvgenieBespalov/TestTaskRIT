package com.example.testtaskrit.data.api

import com.example.testtaskrit.data.model.nationalize.NationalizeModel
import retrofit2.http.GET
import retrofit2.http.Path

interface NationalizeApi {
    @GET("name[]={name}")
    suspend fun getNationalize(@Path("name") name: String): NationalizeModel
}