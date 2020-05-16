package com.kienht.gapo.dashboard.data.repository.source.cache.model

import com.kienht.gapo.dashboard.domain.usecase.news.model.NewsFeed

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

internal fun NewsFeedDAOModel.mapToDomain() =
    NewsFeed(
        id,
        NewsFeed.Type.get(type),
        stories.mapToDomain(),
        post.mapToDomain(),
        friendRequests.mapToDomain()
    )

internal fun NewsFeed.mapToCached() =
    NewsFeedDAOModel(
        id,
        type.value(),
        stories.mapToCached(),
        post.mapToCached(),
        friendRequests.mapToCached()
    )

internal fun List<NewsFeedDAOModel>.mapToDomain() = this.map { it.mapToDomain() }
internal fun List<NewsFeed>.mapToCached() = this.map { it.mapToCached() }
