package com.example.testtaskrit.domain.repository

import com.example.testtaskrit.domain.entity.NationalizeEntity

interface NationalizeRepository {
    suspend fun getNationalize(name : String): NationalizeEntity
}