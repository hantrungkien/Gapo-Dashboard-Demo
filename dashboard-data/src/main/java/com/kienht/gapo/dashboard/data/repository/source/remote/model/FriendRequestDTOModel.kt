package com.kienht.gapo.dashboard.data.repository.source.remote.model

import com.kienht.gapo.dashboard.domain.usecase.news.model.FriendRequest
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

internal fun FriendRequestDTOModel.mapToDomain() = FriendRequest(
    id, friendName, friendAvatar, mutualFriendsCount
)

internal fun List<FriendRequestDTOModel>?.mapToDomain() =
    this?.map { it.mapToDomain() }