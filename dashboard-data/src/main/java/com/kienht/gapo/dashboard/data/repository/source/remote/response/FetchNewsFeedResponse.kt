package com.kienht.gapo.dashboard.data.repository.source.remote.response

import com.kienht.gapo.dashboard.data.repository.source.remote.model.NewsFeedDTOModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
@JsonClass(generateAdapter = true)
data class FetchNewsFeedResponse(
    @Json(name = "id") val data: NewsFeedDTOModel? = null
)