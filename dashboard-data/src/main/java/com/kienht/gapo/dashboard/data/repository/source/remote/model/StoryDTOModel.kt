package com.kienht.gapo.dashboard.data.repository.source.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
@JsonClass(generateAdapter = true)
class StoryDTOModel(
    @Json(name = "id") val id: Long,
    @Json(name = "username") val username: String,
    @Json(name = "userAvatar") val userAvatar: String,
    @Json(name = "contentUrl") val contentUrl: String
)