package com.github.saxypandabear.diskord.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.net.HttpURLConnection
import java.net.URL

enum class RequestMethod {
    GET, POST, DELETE;
}

abstract class Http(protected val baseUrl: String) {
    abstract fun get(endpoint: String, headers: Map<String, String>?): HttpResponse
    abstract fun post(endpoint: String, payload: ByteArray, headers: Map<String, String>?): HttpResponse
}

class HttpClient(private val apiVersion: String) : Http("https://discordapp.com/api") {

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
