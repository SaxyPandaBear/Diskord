package com.github.saxypandabear.diskord.auth

import com.github.saxypandabear.diskord.exception.MissingPropertyException
import com.github.saxypandabear.diskord.util.Properties.BOT_TOKEN_PROPERTY_KEY
import com.github.saxypandabear.diskord.util.Properties.CLIENT_ID_PROPERTY_KEY
import com.github.saxypandabear.diskord.util.Properties.CLIENT_SECRET_PROPERTY_KEY
import java.util.*

interface AuthManager {
    fun getAuthToken(clientId: String, clientSecret: String): String
    fun createAuthorizationHeader(): String
}

/**
 * Takes in a list of strings for the defined scopes that this authentication manager will request for.
 * Defaults to "bot" if given an empty list
 */
class BasicAuthManager(properties: Properties, scopes: List<String>) : AuthManager {

    private val scope = if (scopes.isEmpty()) "bot" else scopes.joinToString(" ")
    private val clientId: String = properties.getProperty(CLIENT_ID_PROPERTY_KEY) ?: throw MissingPropertyException(CLIENT_ID_PROPERTY_KEY)
    private val clientSecret: String = properties.getProperty(CLIENT_SECRET_PROPERTY_KEY) ?: throw MissingPropertyException(
        CLIENT_SECRET_PROPERTY_KEY
    )
    private var authToken: String = ""

    override fun getAuthToken(clientId: String, clientSecret: String): String {
        return "" // TODO: finish this
    }

    override fun createAuthorizationHeader(): String {
        if (authToken.isEmpty()) {
            authToken = getAuthToken(clientId, clientSecret)
        }
        return authToken
    }
}

class BotAuthManager(properties: Properties) : AuthManager {
    private var botAuthToken: String = properties.getProperty(BOT_TOKEN_PROPERTY_KEY)
        ?: throw MissingPropertyException(BOT_TOKEN_PROPERTY_KEY)

    override fun getAuthToken(clientId: String, clientSecret: String): String {
        throw UnsupportedOperationException("Bot clients do not use a client ID and secret to retrieve an access token")
    }

    /**
     * The authorization header for a Bot client is slightly different than a regular OAuth2
     * client.
     */
    override fun createAuthorizationHeader(): String {
        return "Bot $botAuthToken"
    }
}
