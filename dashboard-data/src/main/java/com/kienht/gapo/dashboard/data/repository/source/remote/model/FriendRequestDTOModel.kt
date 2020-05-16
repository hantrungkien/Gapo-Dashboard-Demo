package com.kienht.gapo.dashboard.data.repository.source.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
@JsonClass(generateAdapter = true)
data class FriendRequestDTOModel(
    @Json(name = "id") val id: Long,
    @Json(name = "friendName") val friendName: String,
    @Json(name = "friendAvatar") val friendAvatar: String,
    @Json(name = "mutualFriendsCount") val mutualFriendsCount: Int
)