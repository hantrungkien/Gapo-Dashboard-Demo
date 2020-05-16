package com.kienht.gapo.dashboard.data.repository.source.cache.model


/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
data class FriendRequestDAOModel(
    val id: Long,
    val friendName: String,
    val friendAvatar: String,
    val mutualFriendsCount: Int
)