package com.github.saxypandabear.diskord.common.model

data class Emoji(
    val id: String,
    val name: String?,
    val roles: List<Role>?,
    val user: User?,
    val requireColons: Boolean?,
    val managed: Boolean?,
    val animated: Boolean?
)
