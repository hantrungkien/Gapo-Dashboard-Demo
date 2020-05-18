package com.kienht.gapo.dashboard.data.repository.source.remote.response

import com.kienht.gapo.dashboard.data.repository.source.remote.model.NewsFeedDTOModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author kienht
 */
@JsonClass(generateAdapter = true)
data class FetchNewsFeedResponse(
    @Json(name = "data") val data: List<NewsFeedDTOModel>? = null
)