package com.example.testtaskrit.presentation

import com.example.testtaskrit.domain.entity.DogEntity

sealed interface DogScreenUiState{
    object Initial : DogScreenUiState
    object Loading : DogScreenUiState
    data class Content(val bin: DogEntity) : DogScreenUiState
    data class Error(val message: String?) : DogScreenUiState
}
