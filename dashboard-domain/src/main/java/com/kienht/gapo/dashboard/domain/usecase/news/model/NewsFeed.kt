package com.kienht.gapo.dashboard.domain.usecase.news.model

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
data class NewsFeed(
    val id: Long,
    val type: String,
    val stories: List<Story>?,
    val post: Post?,
    val friendRequests: List<FriendRequest>?
)