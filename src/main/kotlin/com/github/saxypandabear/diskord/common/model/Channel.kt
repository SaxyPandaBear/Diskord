package com.github.saxypandabear.diskord.common.model

import java.time.ZonedDateTime

data class Channel(
    val id: String,
    val aType: Int,
    val guildId: String?,
    val position: Int?,
    val permissionOverwrites: List<Overwrite>?,
    val name: String?,
    val topic: String?,
    val nsfw: Boolean?,
    val lastMessageId: String?,
    val bitrate: Int?,
    val userLimit: Int?,
    val rateLimitPerUser: Int?,
    val recipients: List<User>?,
    val icon: String?,
    val ownerId: String?,
    val applicationId: String?,
    val parentId: String?,
    val lastPinTimestamp: ZonedDateTime?
)

data class Overwrite(
    val id: String,
    val aType: OverwriteType,
    val allow: Int,
    val deny: Int
)

enum class OverwriteType {
    ROLE, MEMBER
}
