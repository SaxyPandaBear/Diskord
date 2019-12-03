package com.github.saxypandabear.diskord.common.model

import java.time.ZonedDateTime

data class GuildMember(
    val user: User,
    val nick: String?,
    val roles: List<String>,
    val joinedAt: ZonedDateTime,
    val premiumSince: ZonedDateTime?,
    val deaf: Boolean,
    val mute: Boolean
)
