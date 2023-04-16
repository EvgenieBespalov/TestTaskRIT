package com.example.testtaskrit.di

import com.example.testtaskrit.data.converter.DogConverter
import com.example.testtaskrit.data.converter.NationalizeConverter
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideDataModule(): Module =
    module {
        factory { DogConverter() }
        factory { NationalizeConverter() }
    }