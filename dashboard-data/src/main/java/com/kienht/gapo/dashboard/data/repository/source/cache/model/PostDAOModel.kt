package com.kienht.gapo.dashboard.data.repository.source.cache.model

import com.kienht.gapo.dashboard.domain.usecase.news.model.Post

/**
 * @author kienht
 */
data class PostDAOModel(
    val id: Long,
    val type: String,
    val username: String,
    val userAvatar: String,
    val time: String,
    val content: String,
    val images: List<String>?,
    val video: String?,
    val likeCount: String,
    val commentCount: String,
    val shareCount: String
)

internal fun PostDAOModel?.mapToDomain() = if (this == null) null else Post(
    id,
    Post.Type.get(type),
    username,
    userAvatar,
    time,
    content,
    images,
    video,
    likeCount,
    commentCount,
    shareCount
)

internal fun Post?.mapToCached() = if (this == null) null else PostDAOModel(
    id,
    type.value(),
    username,
    userAvatar,
    time,
    content,
    images,
    video,
    likeCount,
    commentCount,
    shareCount
)
