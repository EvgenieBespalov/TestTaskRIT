package com.example.testtaskrit.data.repository

import com.example.testtaskrit.data.api.NationalizeApi
import com.example.testtaskrit.data.converter.Converter
import com.example.testtaskrit.domain.entity.NationalizeEntity
import com.example.testtaskrit.domain.repository.NationalizeRepository

class NationalizeRepositoryImpl(
    private val nationalizeApi: NationalizeApi,
    private val nationalizeConverter: Converter,
) : NationalizeRepository {
    override suspend fun getNationalize(name : String): NationalizeEntity =
        nationalizeConverter.converNationalize(nationalizeApi.getNationalize(name))
}