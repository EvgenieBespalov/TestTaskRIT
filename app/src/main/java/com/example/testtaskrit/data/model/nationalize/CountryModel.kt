package com.example.testtaskrit.data.model.nationalize

import com.google.gson.annotations.SerializedName

data class CountryModel(
    @SerializedName("country_id" )
    var countryId: String? = null,
    var probability: Double? = null
)
