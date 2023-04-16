package com.example.testtaskrit.domain.entity.nationalize

data class NationalizeEntity(
    var country: ArrayList<CountryEntity> = arrayListOf(),
    var name: String
)
