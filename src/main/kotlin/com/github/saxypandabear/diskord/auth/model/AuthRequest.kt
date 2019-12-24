package com.github.saxypandabear.diskord.auth.model

data class AuthRequest(
    val clientId: String,
    val clientSecret: String,
    val grantType: String,
    val refreshToken: String?,
    val redirectUri: String? = "https://nicememe.website",
    val scope: String
)
