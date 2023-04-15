package com.example.testtaskrit.domain.usecase

import com.example.testtaskrit.domain.entity.DogEntity
import com.example.testtaskrit.domain.repository.DogRepository

class GetDogUseCase(private val repository: DogRepository) {
    suspend operator fun invoke(): DogEntity = repository.getDog()
}