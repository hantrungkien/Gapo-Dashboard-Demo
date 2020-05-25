package com.kienht.gapo.dashboard.domain.usecase.news.model

/**
 * @author kienht
 */
data class FriendRequest(
    val id: Long,
    val friendName: String,
    val friendAvatar: String,
    val mutualFriendsCount: Int
)
