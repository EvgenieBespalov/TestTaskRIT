package com.example.testtaskrit.domain.usecase

import com.example.testtaskrit.domain.entity.NationalizeEntity
import com.example.testtaskrit.domain.repository.NationalizeRepository

class NationalizeUseCase(private val repository: NationalizeRepository) {
    suspend operator fun invoke(): NationalizeEntity = repository.getNationalize()
}