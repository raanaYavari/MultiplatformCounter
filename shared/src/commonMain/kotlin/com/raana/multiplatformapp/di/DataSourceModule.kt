package com.raana.multiplatformapp.di

import com.raana.multiplatformapp.data.source.remote.service.weather.ProductService
import com.raana.multiplatformapp.data.source.remote.service.weather.ProductServiceImpl
import org.koin.dsl.module


val dataSourceModule = module {
    single<ProductService> {
        ProductServiceImpl(
            get()
        )
    }
}