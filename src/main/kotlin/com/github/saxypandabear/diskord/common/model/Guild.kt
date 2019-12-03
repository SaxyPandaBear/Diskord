package com.github.saxypandabear.diskord.common.model

import java.time.ZonedDateTime

data class Guild(
    val id: String,
    val name: String,
    val icon: String?,
    val splash: String?,
    val owner: Boolean?,
    val ownerId: String,
    val permission: Int,
    val region: String,
    val afkChannelId: String?,
    val afkTimeout: Int,
    val embedEnabled: Boolean?,
    val embedChannelId: String?,
    val verificationLevel: VerificationLevel,
    val defaultMessageNotifications: DefaultMessageNotificationLevel,
    val explicitContentFilter: ExplicitContentFilterLevel,
    val roles: List<Role>,
    val emojis: List<Emoji>,
    val features: List<String>,
    val mfaLevel: MfaLevel,
    val applicationId: String?,
    val widgetEnabled: Boolean?,
    val widgetChannelId: String?,
    val systemChannelId: String?,
    val joinedAt: ZonedDateTime?,
    val large: Boolean?,
    val unavailable: Boolean?,
    val memberCount: Int?,
    val voiceStates: List<VoiceState>?,
    val members: List<GuildMember>?,
    val channels: List<Channel>?,
    val presences: List<Presence>?,
    val maxPresences: Int?,
    val maxMembers: Int?,
    val vanityUrlCode: String?,
    val description: String?,
    val banner: String?,
    val premiumTier: PremiumTier,
    val premiumSubscriptionCount: Int?,
    val preferredLocale: String
)

enum class VerificationLevel(value: Int) {
    NONE(0), LOW(1), MEDIUM(2), HIGH(3), VERY_HIGH(4);

    fun valueOf(value: Int): VerificationLevel? {
        return when (value) {
            0 -> NONE
            1 -> LOW
            2 -> MEDIUM
            3 -> HIGH
            4 -> VERY_HIGH
            else -> null
        }
    }
}

enum class DefaultMessageNotificationLevel(value: Int) {
    ALL_MESSAGES(0), ONLY_MENTIONS(1);

    fun valueOf(value: Int): DefaultMessageNotificationLevel? {
        return when (value) {
            0 -> ALL_MESSAGES
            1 -> ONLY_MENTIONS
            else -> null
        }
    }
}

enum class ExplicitContentFilterLevel(value: Int) {
    DISABLED(0), MEMBERS_WITHOUT_ROLES(1), ALL_MEMBERS(2);

    fun valueOf(value: Int): ExplicitContentFilterLevel? {
        return when (value) {
            0 -> DISABLED
            1 -> MEMBERS_WITHOUT_ROLES
            2 -> ALL_MEMBERS
            else -> null
        }
    }
}

enum class MfaLevel(value: Int) {
    NONE(0), ELEVATED(1);

    fun valueOf(value: Int): MfaLevel? {
        return when (value) {
            0 -> NONE
            1 -> ELEVATED
            else -> null
        }
    }
}

enum class PremiumTier(value: Int) {
    NONE(0), TIER_1(1), TIER_2(2), TIER_3(3);

    fun valueOf(value: Int): PremiumTier? {
        return when (value) {
            0 -> NONE
            1 -> TIER_1
            2 -> TIER_2
            3 -> TIER_3
            else -> null
        }
    }
}
