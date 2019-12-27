package com.github.saxypandabear.diskord.client

/**
 * Aim low for now.
 *
 * A client should be able to read messages and send messages
 */
abstract class Client {
    abstract fun readMessage()
    abstract fun sendMessage()
}
