package com.example.testtaskrit.domain.repository

import com.example.testtaskrit.domain.entity.nationalize.NationalizeEntity

interface NationalizeRepository {
    suspend fun getNationalize(names : ArrayList<String>): List<NationalizeEntity>
}