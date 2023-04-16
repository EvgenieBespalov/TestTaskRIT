package com.example.testtaskrit.di

import com.example.testtaskrit.presentation.DogScreenViewModel
import com.example.testtaskrit.presentation.NationalizeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun providePresentationModule(): Module =
    module {
        viewModel {
            DogScreenViewModel(
                getDogUseCase = get()
            )
        }
        viewModel {
            NationalizeScreenViewModel(
                getNationalizeUseCase = get()
            )
        }
    }