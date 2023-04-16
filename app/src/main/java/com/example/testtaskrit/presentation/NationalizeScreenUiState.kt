package com.example.testtaskrit.presentation

import com.example.testtaskrit.domain.entity.nationalize.NationalizeEntity

sealed interface NationalizeScreenUiState {
    object Initial : NationalizeScreenUiState
    object Loading : NationalizeScreenUiState
    data class Content(val nationalize: List<NationalizeEntity>) : NationalizeScreenUiState
    data class Error(val message: String?) : NationalizeScreenUiState
}
