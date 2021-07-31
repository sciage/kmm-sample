package com.jetbrains.kmm.shared.models

import com.jetbrains.kmm.shared.api.GithubApi
import com.jetbrains.kmm.shared.api.UpdateProblem
import com.jetbrains.kmm.shared.presentation.DataRepository

class MembersDataRepository (private val api: GithubApi): DataRepository {

    override var members: String? = null
    override var onRefreshListeners: List<() -> Unit> = emptyList()

    override suspend fun update() {
        val newMembers = try {
            api.getMembers()
        } catch (cause: Throwable){
            throw UpdateProblem()
        }

        if(newMembers != members){
            members = newMembers
            callRefreshListeners()
        }
    }

    private fun callRefreshListeners(){
        onRefreshListeners.forEach {
            it()
        }
    }

}