package com.example.testtaskrit.domain.usecase

import com.example.testtaskrit.domain.entity.nationalize.NationalizeEntity
import com.example.testtaskrit.domain.repository.NationalizeRepository

class GetNationalizeUseCase(private val repository: NationalizeRepository) {
    suspend operator fun invoke(names: ArrayList<String>): List<NationalizeEntity> = repository.getNationalize(names)
}