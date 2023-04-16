package com.example.testtaskrit.data.converter

import com.example.testtaskrit.data.model.dog.DogModel
import com.example.testtaskrit.data.model.nationalize.CountryModel
import com.example.testtaskrit.data.model.nationalize.NationalizeModel
import com.example.testtaskrit.domain.entity.dog.DogEntity
import com.example.testtaskrit.domain.entity.nationalize.CountryEntity
import com.example.testtaskrit.domain.entity.nationalize.NationalizeEntity

class DogConverter {
    fun converDog(from: DogModel): DogEntity =
        DogEntity(
            message = from.message,
            status = from.status
        )
}