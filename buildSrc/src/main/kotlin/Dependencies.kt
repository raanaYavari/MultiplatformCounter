import Versions.camera
import Versions.cameraView
import Versions.coil
import Versions.constraintLayout
import Versions.firebase
import Versions.firebaseMessaging
import Versions.lingver
import Versions.mapbox
import Versions.materialDialog
import Versions.moko
import Versions.moshiVersion
import Versions.napier
import Versions.wheelPickerComposeVersion
import Versions.zxing
import Versions.zxing_embedded

object Versions {
    const val androidMinSdk = 21
    const val androidCompileSdk = 33
    const val androidTargetSdk = androidCompileSdk

    const val kotlinCoroutines = "1.6.4"
    const val koin = "3.2.1"
    const val ktor = "2.2.2"

    const val kotlinxSerialization = "1.3.3"

    const val compose = "1.3.1"
    const val composeUi = "1.3.1"
    const val composeCompiler = "1.3.2"
    const val navCompose = "2.5.2"
    const val composeMaterial3 = "1.0.0-beta03"
    const val materialIconsExtended = "1.3.1"

    const val junit = "4.12"
    const val androidXTestJUnit = "1.1.3"
    const val testCore = "1.3.0"
    const val mockito = "3.11.2"
    const val robolectric = "4.6.1"

    const val sqlDelight = "1.5.3"
    const val kotlinterGradle = "3.4.5"

    const val activityCompose = "1.6.0-rc02"
    const val lifecycleKtx = "2.6.0-alpha02"
    const val lifecycleRuntimeKtx = lifecycleKtx
    const val lifecycleViewmodelKtx = lifecycleKtx
//    const val osmdroidAndroid = "6.1.10"

    const val kermit = "1.0.0"
    const val gradleVersionsPlugin = "0.39.0"

    const val arrow = "1.0.1"

    const val settings = "1.0.0-RC"

    const val accompanist = "0.28.0"

    const val moko = "0.14.0"

    const val napier = "2.6.1"

    const val zxing = "3.3.0"
    const val zxing_embedded = "4.3.0"

    const val camera = "1.0.2"
    const val cameraView = "1.0.0-alpha31"

    const val collection = "1.3.0-dev01"
    const val datastore = "1.1.0-dev01"

    const val lingver = "1.3.0"
    const val mapbox = "10.10.0-beta.1"
    const val constraintLayout = "2.1.4"

    const val coil = "2.2.2"
    const val viewModel = "1.0.0"

    const val collectionsImmutable = "0.3.5"

    const val materialDialog = "0.9.0"
    const val kotlinxDateTime = "0.4.0"
    const val wheelPickerComposeVersion = "1.1.10"
    const val moshiVersion = "1.12.0"
    const val firebase = "32.1.0"
    const val firebaseMessaging = "22.0.0"
}

object Deps {
    object Gradle {
        const val kotlinter = "org.jmailen.gradle:kotlinter-gradle:${Versions.kotlinterGradle}"
        const val sqlDelight = "com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelight}"
        const val gradleVersionsPlugin =
            "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleVersionsPlugin}"
    }

    object Kotlinx {
        const val serializationCore =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
        const val coroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"

        const val collectionsImmutable =
            "org.jetbrains.kotlinx:kotlinx-collections-immutable:${Versions.collectionsImmutable}"

        const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDateTime}"

    }

    object Android {
//        const val osmdroidAndroid = "org.osmdroid:osmdroid-android:${Versions.osmdroidAndroid}"
    }

    object AndroidX {
        const val benchmarkMacroJunit4 = "androidx.benchmark:benchmark-macro-junit4:1.1.0-rc01"
        const val benchmarkJunit4 = "androidx.benchmark:benchmark-junit4:1.1.0-rc01"
        const val lifecycleRuntimeCompose =
            "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycleRuntimeKtx}"
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
        const val lifecycleViewmodelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewmodelKtx}"
        const val lifecycleViewmodelComposeKtx =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleViewmodelKtx}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
        const val metrics = "androidx.metrics:metrics-performance:1.0.0-alpha01"
        const val testEspressoCore = "androidx.test.espresso:espresso-core:3.4.0"
        const val testExtJunit = "androidx.test.ext:junit:1.1.3"
        const val testUiautomator = "androidx.test.uiautomator:uiautomator:2.2.0"

        const val material3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
        const val material3WindowSizeClass =
            "androidx.compose.material3:material3-window-size-class:${Versions.composeMaterial3}"
        const val splashScreen = "androidx.core:core-splashscreen:1.0.0"

    }

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val androidXTestJUnit = "androidx.test.ext:junit:${Versions.androidXTestJUnit}"
        const val mockito = "org.mockito:mockito-inline:${Versions.mockito}"
        const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
        const val testCore = "androidx.test:core:${Versions.testCore}"

        const val composeUiTest = "androidx.compose.ui:ui-test:${Versions.composeUi}"
        const val composeUiTestJUnit = "androidx.compose.ui:ui-test-junit4:${Versions.composeUi}"
        const val composeUiTestManifest =
            "androidx.compose.ui:ui-test-manifest:${Versions.composeUi}"
        const val composeNavTesting =
            "androidx.navigation:navigation-testing:${Versions.navCompose}"
    }

    object Compose {
        const val compiler = "androidx.compose.compiler:compiler:${Versions.composeCompiler}"
        const val ui = "androidx.compose.ui:ui:${Versions.composeUi}"
        const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.composeUi}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeUi}"
        const val foundationLayout =
            "androidx.compose.foundation:foundation-layout:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val materialIcons =
            "androidx.compose.material:material-icons-extended:${Versions.compose}"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.navCompose}"
        const val materialIconsExtended =
            "androidx.compose.material:material-icons-extended:${Versions.materialIconsExtended}"

        const val coilCompose = "io.coil-kt:coil-compose:2.0.0"
    }

    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
        const val testJUnit4 = "io.insert-koin:koin-test-junit4:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val compose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
    }

    object Ktor {
        const val serverCore = "io.ktor:ktor-server-core:${Versions.ktor}"
        const val serverNetty = "io.ktor:ktor-server-netty:${Versions.ktor}"
        const val auth = "io.ktor:ktor-client-auth:${Versions.ktor}"
        const val serverCors = "io.ktor:ktor-server-cors:${Versions.ktor}"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
        const val json = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
        const val resources = "io.ktor:ktor-client-resources:${Versions.ktor}"

        const val serverContentNegotiation =
            "io.ktor:ktor-server-content-negotiation:${Versions.ktor}"

        const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
        const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
        const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
        const val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
        const val clientJava = "io.ktor:ktor-client-java:${Versions.ktor}"
        const val clientDarwin = "io.ktor:ktor-client-darwin:${Versions.ktor}"
        const val ios = "io.ktor:ktor-client-ios:${Versions.ktor}"
        const val clientOkhttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
//        const val clientJs = "io.ktor:ktor-client-js:${Versions.ktor}"
    }

    object SqlDelight {
        const val runtime = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"
        const val coroutineExtensions =
            "com.squareup.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
        const val androidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
        const val nativeDriver = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"

        //const val nativeDriverMacos = "com.squareup.sqldelight:native-driver-macosx64:${Versions.sqlDelight}"
        const val nativeDriverMacos =
            "com.squareup.sqldelight:native-driver-macosarm64:${Versions.sqlDelight}"
        const val sqliteDriver = "com.squareup.sqldelight:sqlite-driver:${Versions.sqlDelight}"
    }

    object Arrow {
        const val core = "io.arrow-kt:arrow-core:${Versions.arrow}"
        const val fxCoroutines = "io.arrow-kt:arrow-fx-coroutines:${Versions.arrow}"
        const val fxStm = "io.arrow-kt:arrow-fx-stm:${Versions.arrow}"
    }

    object Ok {
        const val okhttp = "com.squareup.okhttp3:okhttp:4.9.2"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.2"
    }

    object Log {
        //        const val slf4j = "org.slf4j:slf4j-simple:${Versions.slf4j}"
//        const val logback = "ch.qos.logback:logback-classic:${Versions.logback}"
        const val kermit = "co.touchlab:kermit:${Versions.kermit}"
    }

    object Settings {
        const val core = "com.russhwolf:multiplatform-settings:${Versions.settings}"
        const val coroutines =
            "com.russhwolf:multiplatform-settings-coroutines:${Versions.settings}"
    }

    object Collection {
        const val core = "androidx.collection:collection:${Versions.collection}"
    }

    object DataStore {
        const val core = "androidx.datastore:datastore-core-okio:${Versions.datastore}"
        const val preferences =
            "androidx.datastore:datastore-preferences-core:${Versions.datastore}"
    }

    object Accompanist {
        const val pager = "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
        const val swipeRefresh =
            "com.google.accompanist:accompanist-swiperefresh:${Versions.accompanist}"
        const val insets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
        const val uiController =
            "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
        const val flowlayout =
            "com.google.accompanist:accompanist-flowlayout:${Versions.accompanist}"
        const val permissions =
            "com.google.accompanist:accompanist-permissions:${Versions.accompanist}"
        const val pagerIndicators =
            "com.google.accompanist:accompanist-pager-indicators:${Versions.accompanist}"
        const val navigationMaterial =
            "com.google.accompanist:accompanist-navigation-material:${Versions.accompanist}"
        const val navigationAnimation =
            "com.google.accompanist:accompanist-navigation-animation:${Versions.accompanist}"
    }

    object Moko {
        const val core = "dev.icerock.moko:mvvm-core:${moko}"
        const val flow = "dev.icerock.moko:mvvm-flow:${moko}"
        const val state = "dev.icerock.moko:mvvm-state:${moko}"

        const val flowCompose = "dev.icerock.moko:mvvm-flow-compose:${moko}"
    }

    object Napier {
        const val core = "io.github.aakira:napier:${napier}"
    }

    object Zxing {
        const val core = "com.google.zxing:core:${zxing}"
        const val embedded = "com.journeyapps:zxing-android-embedded:${zxing_embedded}"
    }

    // Camera
    object Camera {
        const val core = "androidx.camera:camera-camera2:${camera}"
        const val lifecycle = "androidx.camera:camera-lifecycle:${camera}"
        const val view = "androidx.camera:camera-view:${cameraView}"
    }

    object Firebase{
        const val core = "com.google.firebase:firebase-bom:${firebase}"
        const val messaging = "com.google.firebase:firebase-messaging:${firebaseMessaging}"
    }

    object ViewModel {
        const val core = "com.rickclephas.kmm:kmm-viewmodel-core"
    }

    const val Lingver = "com.github.YarikSOffice:lingver:${lingver}"

    const val Coil = "io.coil-kt:coil:${coil}"

    const val MaterialDialogs =
        "io.github.vanpra.compose-material-dialogs:datetime:${materialDialog}"

    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val mapboxSdk = "com.mapbox.maps:android:$mapbox"

    const val wheelPickerCompose =
        "com.github.commandiron:WheelPickerCompose:${wheelPickerComposeVersion}"

    const val moshi = "com.squareup.moshi:moshi-kotlin:$moshiVersion"

}