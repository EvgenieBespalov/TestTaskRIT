package com.example.testtaskrit.di

import com.example.testtaskrit.data.converter.Converter
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideDataModule(): Module =
    module {
        factory { Converter() }
    }