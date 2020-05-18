package com.kienht.gapo.dashboard.data.repository.source.cache.model

import com.kienht.gapo.dashboard.domain.usecase.news.model.FriendRequest

/**
 * @author kienht
 */
data class FriendRequestDAOModel(
    val id: Long,
    val friendName: String,
    val friendAvatar: String,
    val mutualFriendsCount: Int
)

internal fun FriendRequestDAOModel.mapToDomain() = FriendRequest(
    id, friendName, friendAvatar, mutualFriendsCount
)

internal fun FriendRequest.mapToCached() = FriendRequestDAOModel(
    id, friendName, friendAvatar, mutualFriendsCount
)

internal fun List<FriendRequestDAOModel>?.mapToDomain() =
    this?.map { it.mapToDomain() }

internal fun List<FriendRequest>?.mapToCached() =
    this?.map { it.mapToCached() }