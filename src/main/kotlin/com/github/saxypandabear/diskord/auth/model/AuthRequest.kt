package com.github.saxypandabear.diskord.auth.model

/**
 *
data = {
'client_id': CLIENT_ID,
'client_secret': CLIENT_SECRET,
'grant_type': 'refresh_token',
'refresh_token': refresh_token,
'redirect_uri': REDIRECT_URI,
'scope': 'identify email connections'
}
 */
data class AuthRequest(
    val clientId: String,
    val clientSecret: String,
    val grantType: String,
    val refreshToken: String?,
    val redirectUri: String = "https://nicememe.website",
    val scope: String
)