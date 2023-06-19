package com.raana.multiplatformapp

import com.raana.multiplatformapp.di.coreModule
import com.raana.multiplatformapp.di.dataSourceModule
import com.raana.multiplatformapp.di.repositoryModule
import io.ktor.client.engine.darwin.Darwin
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

fun initKoinIos(
): KoinApplication = startKoin {
    modules(
        platformModule,
        coreModule,
        dataSourceModule,
        repositoryModule,
    )
}


actual val platformModule = module {
    single { Darwin.create() }
//    single { DatabaseDriverFactory() }
}


fun <T> Koin.getDependency(objCClass: ObjCClass): T? = getOriginalKotlinClass(objCClass)?.let {
    getDependency(it)
}
