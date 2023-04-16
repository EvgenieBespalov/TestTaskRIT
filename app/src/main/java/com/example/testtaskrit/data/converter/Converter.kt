package com.example.testtaskrit.data.converter

import com.example.testtaskrit.data.model.dog.DogModel
import com.example.testtaskrit.data.model.nationalize.CountryModel
import com.example.testtaskrit.data.model.nationalize.NationalizeModel
import com.example.testtaskrit.domain.entity.CountryEntity
import com.example.testtaskrit.domain.entity.DogEntity
import com.example.testtaskrit.domain.entity.NationalizeEntity

class Converter {
    fun converDog(from: DogModel): DogEntity =
        DogEntity(
            message = from.message,
            status = from.status
        )

    fun converNationalize(from: NationalizeModel): NationalizeEntity =
        NationalizeEntity(
            name = from.name,
            //country = addCountry(from.country)
            country = ArrayList(from.country.map { CountryEntity(it.countryId, it.probability.toString()) })
        )

    fun addCountry(countries: ArrayList<CountryModel>): ArrayList<CountryEntity>{
        var countryEntity: ArrayList<CountryEntity> = arrayListOf()

        countries.forEach {
            arrayListOf<CountryEntity>().add(CountryEntity(it.countryId, it.probability.toString()))
        }

        for (country in countries){
            var countryId = country.countryId
            var probability = country.probability.toString()

            countryEntity.add(CountryEntity(countryId, probability))
        }

        return countryEntity
    }
}