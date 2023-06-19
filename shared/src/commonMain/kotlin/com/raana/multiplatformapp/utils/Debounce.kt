package com.raana.multiplatformapp.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun <A> debounce(
    waitMs: Long = 700L,
    scope: CoroutineScope,
    destinationFunction: (A) -> Unit
): (A) -> Unit {
    var debounceJob: Job? = null
    return { A ->
        debounceJob?.cancel()
        debounceJob = scope.launch {
            delay(waitMs)
            destinationFunction(A)
        }
    }
}
