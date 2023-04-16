package com.example.testtaskrit.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskrit.domain.usecase.GetDogUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class DogScreenViewModel (
    private val getDogUseCase: GetDogUseCase
): ViewModel() {

    private val _state: MutableLiveData<DogScreenUiState> = MutableLiveData(DogScreenUiState.Initial)
    val state: LiveData<DogScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = DogScreenUiState.Initial
        }
    }

    fun getDog(){
        viewModelScope.launch {
            _state.value = DogScreenUiState.Loading

            try {
                val binData = getDogUseCase()
                _state.value = binData.let { DogScreenUiState.Content(it) }
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = DogScreenUiState.Error(ex.message)
            }

        }
    }

}