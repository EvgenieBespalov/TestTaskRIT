package com.example.testtaskrit.presentation

import com.example.testtaskrit.domain.entity.DogEntity
import com.example.testtaskrit.domain.entity.NationalizeEntity

sealed interface NationalizeScreenUiState {
    object Initial : NationalizeScreenUiState
    object Loading : NationalizeScreenUiState
    data class Content(val nationalize: NationalizeEntity) : NationalizeScreenUiState
    data class Error(val message: String?) : NationalizeScreenUiState
}
