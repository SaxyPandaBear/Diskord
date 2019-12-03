package com.github.saxypandabear.diskord.common.model

data class Presence(
    val user: User,
    val roles: List<String>,
    val game: Activity?,
    val guildId: String,
    val status: String,
    val activities: List<Activity>,
    val clientStatus: ClientStatus
)

data class ClientStatus(
    val desktop: String?,
    val mobile: String?,
    val web: String?
)
