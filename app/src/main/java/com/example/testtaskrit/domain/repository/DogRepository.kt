package com.example.testtaskrit.domain.repository

import com.example.testtaskrit.domain.entity.DogEntity

interface DogRepository {
    suspend fun getDog(): DogEntity
}