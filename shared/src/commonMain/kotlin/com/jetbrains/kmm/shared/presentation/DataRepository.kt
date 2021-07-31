package com.jetbrains.kmm.shared.presentation

interface DataRepository {
    val members: String?
    var onRefreshListeners: List<() -> Unit>

    suspend fun update()
}