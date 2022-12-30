package com.example.binlistnet.app

import android.app.Application
import com.example.binlistnet.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(){
            androidContext(this@App)
            modules(
                listOf(
                   retrofitModule, repositoryModule, viewModelModel, dataBaseModule
                )
            )
        }
    }
}