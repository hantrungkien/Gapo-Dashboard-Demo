package com.kienht.gapo.dashboard.data.repository.source.cache.model

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
data class NewsFeedDAOModel(
    val id: Long,
    val type: String,
    val stories: List<StoryDAOModel>?,
    val post: PostDAOModel?,
    val friendRequests: List<FriendRequestDAOModel>?
)