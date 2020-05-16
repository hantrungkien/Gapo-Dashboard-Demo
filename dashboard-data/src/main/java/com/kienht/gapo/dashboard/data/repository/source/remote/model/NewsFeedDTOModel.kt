package com.kienht.gapo.dashboard.data.repository.source.remote.model

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