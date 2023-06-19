plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(Deps.Ktor.coroutinesAndroid)
                implementation(Deps.Ktor.clientAndroid)
                implementation(Deps.Ktor.clientOkhttp)
                implementation(Deps.SqlDelight.androidDriver)
                implementation(Deps.AndroidX.lifecycleViewmodelKtx)
                implementation(Deps.AndroidX.lifecycleViewmodelComposeKtx)
            }
        }
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)


                with(Deps.Ktor) {
                    implementation(clientCore)
                    implementation(clientJson)
                    implementation(clientLogging)
                    implementation(auth)
                    implementation(contentNegotiation)
                    implementation(json)
                    implementation(resources)
                }

                with(Deps.Kotlinx) {
                    implementation(serializationCore)
                    implementation(coroutinesCore)
                    implementation(dateTime)
                }

                with(Deps.Koin) {
                    api(core)
                    api(test)
                }
                with(Deps.Arrow) {
                    implementation(core)
                    implementation(fxCoroutines)
                    implementation(fxStm)
                }
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val iosMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(Deps.Ktor.clientDarwin)
                implementation(Deps.SqlDelight.nativeDriver)
            }
        }
    }
}

android {
    namespace = "com.raana.multiplatformapp"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}