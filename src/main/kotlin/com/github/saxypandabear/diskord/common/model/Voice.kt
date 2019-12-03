package com.github.saxypandabear.diskord.common.model

data class VoiceState(
    val guildId: String?,
    val channelId: String?,
    val userId: String,
    val member: GuildMember?,
    val sessionId: String,
    val deaf: Boolean,
    val mute: Boolean,
    val selfDeaf: Boolean,
    val selfMute: Boolean,
    val selfStream: Boolean?,
    val suppress: Boolean
)

data class VoiceRegion(
    val id: String,
    val name: String,
    val vip: Boolean,
    val optimal: Boolean,
    val deprecated: Boolean,
    val custom: Boolean
)
