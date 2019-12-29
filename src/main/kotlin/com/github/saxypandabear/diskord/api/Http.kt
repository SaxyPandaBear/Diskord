package com.github.saxypandabear.diskord.api

import com.github.saxypandabear.diskord.util.JacksonUtil
import java.net.HttpURLConnection
import java.net.URL

enum class RequestMethod {
    GET, POST, DELETE;
}

abstract class Http(protected val baseUrl: String) {
    abstract fun get(endpoint: String, headers: Map<String, String>? = null): HttpResponse
    abstract fun post(
        endpoint: String,
        payload: Any,
        headers: Map<String, String>? = null,
        payloadToByteArrayFunction: ((payload: Any) -> ByteArray)? = null
    ): HttpResponse

    abstract fun post(endpoint: String, payload: String, headers: Map<String, String>? = null): HttpResponse
    abstract fun post(endpoint: String, payload: ByteArray, headers: Map<String, String>? = null): HttpResponse
    abstract fun delete(endpoint: String, headers: Map<String, String>? = null): HttpResponse
}

class HttpClient(val apiVersion: String) : Http("https://discordapp.com/api") {

    override fun get(endpoint: String, headers: Map<String, String>?): HttpResponse {
        val url = URL("$baseUrl/$apiVersion/${stripSlashes(endpoint)}")
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

    override fun post(
        endpoint: String,
        payload: Any,
        headers: Map<String, String>?,
        payloadToByteArrayFunction: ((payload: Any) -> ByteArray)?
    ): HttpResponse {
        return if (payloadToByteArrayFunction != null) {
            post(endpoint, payloadToByteArrayFunction(payload), headers)
        } else {
            post(endpoint, JacksonUtil.objectMapper.writeValueAsBytes(payload), headers)
        }
    }

    override fun post(endpoint: String, payload: String, headers: Map<String, String>?): HttpResponse {
        return post(endpoint, payload.toByteArray(), headers)
    }

    override fun post(endpoint: String, payload: ByteArray, headers: Map<String, String>?): HttpResponse {
        val url = URL("$baseUrl/$apiVersion/${stripSlashes(endpoint)}")
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

    override fun delete(endpoint: String, headers: Map<String, String>?): HttpResponse {
        val url = URL("$baseUrl/$apiVersion/${stripSlashes(endpoint)}")
        with(url.openConnection() as HttpURLConnection) {
            headers?.let {
                for ((k, v) in it) {
                    addRequestProperty(k, v)
                }
            }
            requestMethod = RequestMethod.DELETE.name

            return HttpResponse(this)
        }
    }

    /**
     * convenience method for dealing with input that has leading or trailing forward slashes
     */
    private fun stripSlashes(endpoint: String): String {
        return endpoint.trim { c -> c == '/' }
    }
}
