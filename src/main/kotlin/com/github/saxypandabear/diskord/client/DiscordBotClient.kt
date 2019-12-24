package com.github.saxypandabear.diskord.client

import com.github.saxypandabear.diskord.auth.AuthManager
import com.github.saxypandabear.diskord.auth.AuthenticationUtil
import com.github.saxypandabear.diskord.http.Http
import com.github.saxypandabear.diskord.http.HttpClient
import java.util.*

class DiscordBotClient(properties: Properties) : Client(properties) {
    private val authManager: AuthManager = AuthenticationUtil.createAuthManager(properties)
    private val httpClient: Http = HttpClient(properties)
}