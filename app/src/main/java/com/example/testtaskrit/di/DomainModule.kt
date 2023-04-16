package com.example.testtaskrit.di

import com.example.testtaskrit.data.api.DogApi
import com.example.testtaskrit.data.api.NationalizeApi
import com.example.testtaskrit.data.converter.DogConverter
import com.example.testtaskrit.data.converter.NationalizeConverter
import com.example.testtaskrit.data.repository.DogRepositoryImpl
import com.example.testtaskrit.data.repository.NationalizeRepositoryImpl
import com.example.testtaskrit.domain.repository.DogRepository
import com.example.testtaskrit.domain.repository.NationalizeRepository
import com.example.testtaskrit.domain.usecase.GetDogUseCase
import com.example.testtaskrit.domain.usecase.GetNationalizeUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

private fun provideDogApiRepository(
    dogApi: DogApi,
    converter: DogConverter
): DogRepository = DogRepositoryImpl(dogApi, converter)

private fun provideNationalizeApiRepository(
    nationalizeApi: NationalizeApi,
    converter: NationalizeConverter
): NationalizeRepository = NationalizeRepositoryImpl(nationalizeApi, converter)

fun provideDomainModule(): Module =
    module {
        single { provideDogApiRepository(
            dogApi = get(),
            converter = get())
        }

        single { provideNationalizeApiRepository(
            nationalizeApi = get(),
            converter = get())
        }

        factory { GetDogUseCase(repository = get()) }
        factory { GetNationalizeUseCase(repository = get()) }
    }