package com.github.saxypandabear.diskord.client

import com.github.saxypandabear.diskord.auth.AuthManager
import com.github.saxypandabear.diskord.api.Gateway
import com.github.saxypandabear.diskord.api.Http

/**
 * A bot client needs a way to authenticate against Discord,
 * a RESTful HTTP client, and a gateway implementation for accepting events from
 * Discord via web sockets
 */
class DiscordBotClient(authManager: AuthManager, http: Http, gateway: Gateway) : Client() {
    override fun readMessage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendMessage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}