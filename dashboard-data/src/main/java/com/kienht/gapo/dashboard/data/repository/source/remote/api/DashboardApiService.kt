package com.kienht.gapo.dashboard.data.repository.source.remote.api

import com.kienht.gapo.dashboard.data.repository.source.remote.response.FetchNewsFeedResponse
import retrofit2.http.GET

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
internal interface DashboardApiService {

    companion object {
        const val BASE_URL = "https://api.gapo.vn/v1/rest/"
    }

    @GET("auth/login")
    suspend fun fetchNewsFeedData(): FetchNewsFeedResponse
}