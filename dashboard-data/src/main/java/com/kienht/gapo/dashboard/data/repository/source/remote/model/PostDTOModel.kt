package com.kienht.gapo.dashboard.data.repository.source.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
@JsonClass(generateAdapter = true)
data class PostDTOModel(
    @Json(name = "id") val id: Long,
    @Json(name = "type") val type: String,
    @Json(name = "username") val username: String,
    @Json(name = "userAvatar") val userAvatar: String,
    @Json(name = "time") val time: String,
    @Json(name = "content") val content: String,
    @Json(name = "images") val images: List<String>?,
    @Json(name = "video") val video: String?,
    @Json(name = "likeCount") val likeCount: String,
    @Json(name = "commentCount") val commentCount: String,
    @Json(name = "shareCount") val shareCount: String
)