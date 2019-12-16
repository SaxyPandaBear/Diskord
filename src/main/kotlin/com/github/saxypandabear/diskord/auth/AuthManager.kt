package com.github.saxypandabear.diskord.auth

import com.github.saxypandabear.diskord.util.PropertiesUtil
import com.github.saxypandabear.diskord.util.PropertiesUtil.BOT_TOKEN_PROPERTY_KEY
import com.github.saxypandabear.diskord.util.PropertiesUtil.CLIENT_ID_PROPERTY_KEY
import com.github.saxypandabear.diskord.util.PropertiesUtil.CLIENT_SECRET_PROPERTY_KEY
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

    // the scope is the space delimited list of values that define the accesses that this authentication is asking for
    private val scope = if (scopes.isEmpty()) "bot" else scopes.joinToString(" ")

    // the client ID is the ID (duh)
    private val clientId: String = PropertiesUtil.getValue(CLIENT_ID_PROPERTY_KEY, properties)

    // the client secret is the secret (duh)
    private val clientSecret: String = PropertiesUtil.getValue(CLIENT_SECRET_PROPERTY_KEY, properties)

    // the auth token is a local reference to the response from the Discord authentication endpoint
    private var authToken: String = ""

    override fun getAuthToken(clientId: String, clientSecret: String): String {
        return "" // TODO: finish this
    }

    override fun createAuthorizationHeader(): String {
        if (authToken.isEmpty()) {
            authToken = getAuthToken(clientId, clientSecret)
        }
        return "Bearer $authToken"
    }
}

class BotAuthManager(properties: Properties) : AuthManager {
    private var botAuthToken: String = PropertiesUtil.getValue(BOT_TOKEN_PROPERTY_KEY, properties)

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
