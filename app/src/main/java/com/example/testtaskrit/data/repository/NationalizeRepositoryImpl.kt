package com.example.testtaskrit.data.repository

import com.example.testtaskrit.data.api.NationalizeApi
import com.example.testtaskrit.data.converter.NationalizeConverter
import com.example.testtaskrit.domain.entity.nationalize.NationalizeEntity
import com.example.testtaskrit.domain.repository.NationalizeRepository

class NationalizeRepositoryImpl(
    private val nationalizeApi: NationalizeApi,
    private val nationalizeConverter: NationalizeConverter,
) : NationalizeRepository {
    override suspend fun getNationalize(names : List<String>): List<NationalizeEntity> =
        nationalizeApi.getNationalize(names).map { nationalizeConverter.converNationalize(it) }
}