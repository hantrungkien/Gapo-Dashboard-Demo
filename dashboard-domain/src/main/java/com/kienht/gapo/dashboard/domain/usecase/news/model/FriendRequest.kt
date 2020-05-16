package com.kienht.gapo.dashboard.domain.usecase.news.model


/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
data class FriendRequest(
    val id: Long,
    val friendName: String,
    val friendAvatar: String,
    val mutualFriendsCount: Int
)