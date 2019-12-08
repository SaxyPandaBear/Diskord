package com.github.saxypandabear.diskord.auth

import java.lang.Exception
import java.lang.NullPointerException
import java.lang.RuntimeException
import java.nio.file.Paths
import java.util.*
import com.github.saxypandabear.diskord.auth.AuthenticationType.*

/**
 * Manage client credential patterns for a Discord client.
 * This is defined in the application.properties file.
 *
 * There are
 */
object AuthenticationUtil {

    private val AUTH_TYPE_PROPERTY_KEY = "diskord.auth.type"

    fun createAuthManager(propertiesFile: String): AuthManager {
        val file = Paths.get(propertiesFile).toFile()
        if (!file.isFile) {
            throw RuntimeException("Error reading file: $propertiesFile")
        }
        try {
            val properties = Properties()
            file.inputStream().use {
                properties.load(it)
                return createAuthManager(properties)
            }
        } catch (e: Exception) {
            throw e
        }
    }

    fun createAuthManager(properties: Properties): AuthManager {
        return when (deriveAuthenticationType(properties)) {
            BOT -> BotAuthManager(properties)
            else -> throw Exception()
        }
    }



    private fun deriveAuthenticationType(properties: Properties): AuthenticationType {
        val authType = properties.getProperty(AUTH_TYPE_PROPERTY_KEY)
        when (authType?.toLowerCase()) {
            "bot" -> return BOT
            else -> throw RuntimeException("Could not determine the authentication type: $authType")
        }
    }
}