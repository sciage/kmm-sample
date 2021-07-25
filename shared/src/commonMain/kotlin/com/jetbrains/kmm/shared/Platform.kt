package com.jetbrains.kmm.shared

import kotlin.coroutines.CoroutineContext

expect class Platform() {
    val platform: String
}

internal expect val ApplicationDispatcher: CoroutineContext