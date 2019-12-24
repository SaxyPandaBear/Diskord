package com.github.saxypandabear.diskord.util

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

object JacksonUtil {
    // use this object mapper so that we don't have to redefine an object mapper everywhere
    val objectMapper = jacksonObjectMapper()
}