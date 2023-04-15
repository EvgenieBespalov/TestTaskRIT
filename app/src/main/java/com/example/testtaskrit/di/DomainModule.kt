package com.example.testtaskrit.di

import com.example.testtaskrit.data.api.DogApi
import com.example.testtaskrit.data.converter.Converter
import com.example.testtaskrit.data.repository.DogRepositoryImpl
import com.example.testtaskrit.domain.repository.DogRepository
import com.example.testtaskrit.domain.usecase.GetDogUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

private fun provideDogApiRepository(
    dogApi: DogApi,
    converter: Converter
): DogRepository = DogRepositoryImpl(dogApi, converter)

fun provideDomainModule(): Module =
    module {
        single { provideDogApiRepository(
            dogApi = get(),
            converter = get()) }

        factory { GetDogUseCase(repository = get()) }
    }