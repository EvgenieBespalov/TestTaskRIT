package com.example.testtaskrit.data.converter

import com.example.testtaskrit.data.model.nationalize.NationalizeModel
import com.example.testtaskrit.domain.entity.nationalize.CountryEntity
import com.example.testtaskrit.domain.entity.nationalize.NationalizeEntity

class NationalizeConverter {
    fun converNationalize(from: NationalizeModel): NationalizeEntity =
        NationalizeEntity(
            name = from.name,
            country = ArrayList(from.country.map { CountryEntity(it.countryId, it.probability.toString()) })
        )
}