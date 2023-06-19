package com.raana.multiplatformapp.di

import com.raana.multiplatformapp.data.source.remote.ApiClient
import com.raana.multiplatformapp.platformModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun initKoin(appModule: Module): KoinApplication {
    val koinApplication = startKoin {
        modules(
            platformModule + coreModule + dataSourceModule + repositoryModule + appModule
        )
    }

    return koinApplication
}

val coreModule = module {

    single {
        ApiClient(
            get()
        )
    }

}

