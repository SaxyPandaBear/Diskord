package com.github.saxypandabear.diskord.common.model

import java.time.ZonedDateTime

data class ServerIntegration(
    val id: String,
    val name: String,
    val aType: String,
    val enabled: Boolean,
    val syncing: Boolean,
    val roleId: String,
    val expireBehavior: Int,
    val expireGracePeriod: Int,
    val user: User,
    val account: IntegrationAccount,
    val syncedAt: ZonedDateTime
)

data class IntegrationAccount(
    val id: String,
    val name: String
)
