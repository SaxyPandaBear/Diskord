package com.github.saxypandabear.diskord.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.saxypandabear.diskord.util.PropertiesUtil
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

enum class RequestMethod {
    GET, POST, DELETE;
}

abstract class Http(protected val baseUrl: String) {
    abstract fun get(endpoint: String, headers: Map<String, String>? = null): HttpResponse
    abstract fun post(endpoint: String, payload: Any, headers: Map<String, String>? = null): HttpResponse
    abstract fun post(endpoint: String, payload: String, headers: Map<String, String>? = null): HttpResponse
    abstract fun post(endpoint: String, payload: ByteArray, headers: Map<String, String>? = null): HttpResponse
}

class HttpClient(private val apiVersion: String) : Http("https://discordapp.com/api") {

    constructor(properties: Properties) : this(PropertiesUtil.getValue(PropertiesUtil.API_VERSION, properties))

    private val objectMapper: ObjectMapper = jacksonObjectMapper()

    override fun get(endpoint: String, headers: Map<String, String>?): HttpResponse {
        val url = URL("$baseUrl/$apiVersion/$endpoint")
        with(url.openConnection() as HttpURLConnection) {
            headers?.let {
                for ((k, v) in it) {
                    addRequestProperty(k, v)
                }
            }
            requestMethod = RequestMethod.GET.name

            return HttpResponse(this)
        }
    }

    override fun post(endpoint: String, payload: Any, headers: Map<String, String>?): HttpResponse {
        return post(endpoint, objectMapper.writeValueAsBytes(payload), headers)
    }

    override fun post(endpoint: String, payload: String, headers: Map<String, String>?): HttpResponse {
        return post(endpoint, payload.toByteArray(), headers)
    }

    override fun post(endpoint: String, payload: ByteArray, headers: Map<String, String>?): HttpResponse {
        val url = URL("$baseUrl/$apiVersion/$endpoint")
        with(url.openConnection() as HttpURLConnection) {
            headers?.let {
                for ((k, v) in it) {
                    addRequestProperty(k, v)
                }
            }
            requestMethod = RequestMethod.POST.name
            outputStream.write(payload)
            outputStream.close()

            return HttpResponse(this)
        }
    }
}
