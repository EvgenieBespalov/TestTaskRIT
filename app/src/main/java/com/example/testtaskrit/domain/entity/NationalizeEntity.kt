package com.example.testtaskrit.domain.entity

data class NationalizeEntity(
    var country: ArrayList<CountryEntity> = arrayListOf(),
    var name: String? = null
)
