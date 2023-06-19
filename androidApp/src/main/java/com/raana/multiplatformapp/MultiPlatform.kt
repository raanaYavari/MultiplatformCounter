package com.raana.multiplatformapp

import android.app.Application
import com.raana.multiplatformapp.android.di.appModule
import com.raana.multiplatformapp.di.initKoin

class MultiPlatform : Application(){

    override fun onCreate() {
        super.onCreate()
        initKoin(
            appModule(this@MultiPlatform)
        )
    }
}