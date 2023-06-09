package com.example.testtaskrit.data.converter

import com.example.testtaskrit.data.model.dog.DogModel
import com.example.testtaskrit.domain.entity.dog.DogEntity

class DogConverter {
    fun converDog(from: DogModel): DogEntity =
        DogEntity(
            message = from.message,
            status = from.status
        )
}