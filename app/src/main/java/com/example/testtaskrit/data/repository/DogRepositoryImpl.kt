package com.example.testtaskrit.data.repository

import com.example.testtaskrit.data.api.DogApi
import com.example.testtaskrit.data.converter.Converter
import com.example.testtaskrit.domain.entity.DogEntity
import com.example.testtaskrit.domain.repository.DogRepository

class DogRepositoryImpl(
    private val dogApi: DogApi,
    private val dogConverter: Converter,
) : DogRepository{
    override suspend fun getDog(): DogEntity =
        dogConverter.converDog(dogApi.getRandomDog())
}