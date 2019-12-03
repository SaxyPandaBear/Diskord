package com.github.saxypandabear.diskord.common.model

data class User(
    val id: String,
    val username: String,
    val discriminator: String,
    val avatar: String?,
    val bot: Boolean?,
    val system: Boolean?,
    val mfaEnabled: Boolean?,
    val locale: String?,
    val verified: Boolean?,
    val email: String?,
    val flags: Int?,
    val premiumType: Int?
)
