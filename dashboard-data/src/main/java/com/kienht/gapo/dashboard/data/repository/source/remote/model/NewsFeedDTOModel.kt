package com.kienht.gapo.dashboard.data.repository.source.remote.model

import com.kienht.gapo.dashboard.domain.usecase.news.model.NewsFeed
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
@JsonClass(generateAdapter = true)
data class NewsFeedDTOModel(
    @Json(name = "id") val id: Long,
    @Json(name = "type") val type: String,
    @Json(name = "stories") val stories: List<StoryDTOModel>?,
    @Json(name = "post") val post: PostDTOModel?,
    @Json(name = "friendRequests") val friendRequests: List<FriendRequestDTOModel>?
)

internal fun NewsFeedDTOModel.mapToDomain() =
    NewsFeed(
        id,
        NewsFeed.Type.get(type),
        stories.mapToDomain(),
        post.mapToDomain(),
        friendRequests.mapToDomain()
    )

internal fun List<NewsFeedDTOModel>.mapToDomain() = this.map { it.mapToDomain() }
