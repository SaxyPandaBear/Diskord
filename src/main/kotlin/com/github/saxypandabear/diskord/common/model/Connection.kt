package com.github.saxypandabear.diskord.common.model

data class Connection(
    val id: String,
    val name: String,
    val aType: String,
    val revoked: Boolean,
    val integrations: List<ServerIntegration>,
    val verified: Boolean,
    val friendSync: Boolean,
    val showActivity: Boolean,
    val visibility: Int
)
