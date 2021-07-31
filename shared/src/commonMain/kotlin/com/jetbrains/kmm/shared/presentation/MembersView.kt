package com.jetbrains.kmm.shared.presentation

interface MembersView: BaseView {
    var isUpdating: Boolean
    fun onUpdate(members: String)
}