package com.github.saxypandabear.diskord.util

import com.github.saxypandabear.diskord.exception.MissingPropertyException
import java.io.FileInputStream
import java.util.*

object PropertiesUtil {
    const val BOT_TOKEN_PROPERTY_KEY = "diskord.bot.token"
    const val CLIENT_ID_PROPERTY_KEY = "diskord.client.id"
    const val CLIENT_SECRET_PROPERTY_KEY = "diskord.client.secret"
    const val API_VERSION = "diskord.api.version"

    fun getValue(key: String, properties: Properties): String {
        return properties.getProperty(key) ?: throw MissingPropertyException(key)
    }

    fun readProperties(filepath: String): Properties {
        val properties = Properties()
        properties.load(FileInputStream(filepath))

        return properties
    }
}