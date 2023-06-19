package com.raana.multiplatformapp

import org.koin.core.Koin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import kotlin.reflect.KClass

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect val platformModule: Module


@Suppress("UNCHECKED_CAST")
fun <T> Koin.getDependency(clazz: KClass<*>): T {
    return get(clazz, null) { parametersOf(clazz.simpleName) } as T
}