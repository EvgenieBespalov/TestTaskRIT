package com.example.testtaskrit.data.converter

import com.example.testtaskrit.data.model.dog.DogModel
import com.example.testtaskrit.domain.entity.DogEntity

class Converter {
    fun converDog(from: DogModel): DogEntity =
        DogEntity(
            message = from.message,
            status = from.status
        )
}