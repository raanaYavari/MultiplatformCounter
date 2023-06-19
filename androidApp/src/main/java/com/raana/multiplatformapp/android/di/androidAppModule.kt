package com.raana.multiplatformapp.android.di

import android.app.Application
import android.content.Context
import org.koin.dsl.module

fun appModule(app: Application) = module {

    single<Context> {
        app
    }
}