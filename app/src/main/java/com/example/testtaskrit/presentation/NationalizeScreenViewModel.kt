package com.example.testtaskrit.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskrit.domain.usecase.GetNationalizeUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class NationalizeScreenViewModel(
    private val getNationalizeUseCase: GetNationalizeUseCase
): ViewModel() {

    private val _state: MutableLiveData<NationalizeScreenUiState> = MutableLiveData(NationalizeScreenUiState.Initial)
    val state: LiveData<NationalizeScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = NationalizeScreenUiState.Initial
        }
    }

    fun getNationalize(names: List<String>){
        viewModelScope.launch {
            _state.value = NationalizeScreenUiState.Loading

            try {
                val binData = getNationalizeUseCase(names)
                _state.value = binData.let { NationalizeScreenUiState.Content(it) }
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = NationalizeScreenUiState.Error(ex.message)
            }

        }
    }

}