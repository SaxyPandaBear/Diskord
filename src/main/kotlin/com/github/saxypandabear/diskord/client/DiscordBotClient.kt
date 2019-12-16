package com.github.saxypandabear.diskord.client

import com.github.saxypandabear.diskord.auth.AuthenticationUtil
import com.github.saxypandabear.diskord.auth.BotAuthManager
import com.github.saxypandabear.diskord.util.PropertiesUtil
import java.util.*

class DiscordBotClient(properties: Properties) : Client(properties) {
    private val authManager = AuthenticationUtil.createAuthManager(properties)
}