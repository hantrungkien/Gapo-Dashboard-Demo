package com.kienht.gapo.dashboard.data.repository.source.cache.model

import com.kienht.gapo.dashboard.domain.usecase.news.model.Story

/**
 * @author kienht
 */
data class StoryDAOModel(
    val id: Long,
    val username: String,
    val userAvatar: String,
    val contentUrl: String
)

internal fun StoryDAOModel.mapToDomain() = Story(id, username, userAvatar, contentUrl)
internal fun Story.mapToCached() = StoryDAOModel(id, username, userAvatar, contentUrl)

internal fun List<StoryDAOModel>?.mapToDomain() = this?.map { it.mapToDomain() }
internal fun List<Story>?.mapToCached() = this?.map { it.mapToCached() }
