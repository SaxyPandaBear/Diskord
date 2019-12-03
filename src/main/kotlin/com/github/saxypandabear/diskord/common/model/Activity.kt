package com.github.saxypandabear.diskord.common.model

data class Activity(
    val name: String,
    val aType: ActivityType,
    val url: String?,
    val createdAt: Int,
    val timestamps: ActivityTimestamps?,
    val applicationId: String?,
    val details: String?,
    val state: String?,
    val emoji: ActivityEmoji?,
    val party: ActivityParty?,
    val assets: ActivityAssets?,
    val secrets: ActivitySecrets?,
    val instance: Boolean?,
    val flags: Int?
)

enum class ActivityType(value: Int) {
    GAME(0), STREAMING(1), LISTENING(2), CUSTOM(4);

    fun valueOf(value: Int): ActivityType? {
        return when (value) {
            0 -> GAME
            1 -> STREAMING
            2 -> LISTENING
            4 -> CUSTOM
            else -> null
        }
    }
}

data class ActivityTimestamps(
    val start: Long?,
    val end: Long?
)

data class ActivityEmoji(
    val name: String,
    val id: String?,
    val animated: Boolean?
)

data class ActivityParty(
    val id: String?,
    val size: List<Int>?
)

data class ActivityAssets(
    val largeImage: String?,
    val largeText: String?,
    val smallImage: String?,
    val smallText: String?
)

data class ActivitySecrets(
    val join: String?,
    val spectate: String?,
    val match: String?
)
