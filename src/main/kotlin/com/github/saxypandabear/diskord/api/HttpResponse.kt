package com.github.saxypandabear.diskord.api

import java.io.InputStream
import java.net.HttpURLConnection

/**
 * Wrapper class that contains all of the information from an HTTP URL connection so it can be closed while
 * maintaining the data
 */
data class HttpResponse(val inputStream: InputStream, val responseCode: Int, val headers: Map<String, List<String>>) {

    constructor(httpURLConnection: HttpURLConnection) : this(
        httpURLConnection.inputStream,
        httpURLConnection.responseCode,
        httpURLConnection.headerFields
    )
}
