package com.kienht.gapo.dashboard.data.repository.source.remote.model

import com.kienht.gapo.dashboard.domain.usecase.news.model.Story
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author kienht
 */
@JsonClass(generateAdapter = true)
data class StoryDTOModel(
    @Json(name = "id") val id: Long,
    @Json(name = "username") val username: String,
    @Json(name = "userAvatar") val userAvatar: String,
    @Json(name = "contentUrl") val contentUrl: String
)

internal fun StoryDTOModel.mapToDomain() = Story(id, username, userAvatar, contentUrl)

internal fun List<StoryDTOModel>?.mapToDomain() = this?.map { it.mapToDomain() }
