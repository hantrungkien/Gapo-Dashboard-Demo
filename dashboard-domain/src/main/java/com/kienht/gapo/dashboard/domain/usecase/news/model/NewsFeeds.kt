package com.kienht.gapo.dashboard.domain.usecase.news.model

/**
 * @author kienht
 */
data class NewsFeeds(
    val id: Long,
    val type: Type,
    val stories: List<Story>?,
    val post: Post?,
    val friendRequests: List<FriendRequest>?
) {

    enum class Type {

        STORY {
            override fun value(): String = "STORY"
        },
        POST {
            override fun value(): String = "POST"
        },
        FRIEND_REQUEST {
            override fun value(): String = "FRIEND_REQUEST"
        };

        abstract fun value(): String

        companion object {
            fun get(value: String) = values().first { it.value().equals(value, true) }
        }
    }
}