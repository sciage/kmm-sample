package com.jetbrains.kmm.shared.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlin.collections.get

class GithubApi {
    private val client = HttpClient()

    private val membersUrl = Url("https://api.github.com/orgs/raywenderlich/members")

    suspend fun getMembers(): String {
        val result : String = client.get{
            url(this@GithubApi.membersUrl.toString())
        }
        return result
    }
}