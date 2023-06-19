import SwiftUI
import shared

func startKoin() {
    let koinApplication = PlatformKt.doInitKoinIos()
    _koin = koinApplication.koin
}
