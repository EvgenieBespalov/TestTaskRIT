package com.example.testtaskrit

import android.app.Application
import com.example.testtaskrit.di.provideDataModule
import com.example.testtaskrit.di.provideDomainModule
import com.example.testtaskrit.di.provideNetworkModule
import com.example.testtaskrit.di.providePresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                provideNetworkModule(),
                provideDataModule(),
                provideDomainModule(),
                providePresentationModule(),
                //provideDataBaseModule(),
            )
        }
    }
}