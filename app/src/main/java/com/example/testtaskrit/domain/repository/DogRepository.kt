package com.example.testtaskrit.domain.repository

import com.example.testtaskrit.domain.entity.dog.DogEntity

interface DogRepository {
    suspend fun getDog(): DogEntity
}