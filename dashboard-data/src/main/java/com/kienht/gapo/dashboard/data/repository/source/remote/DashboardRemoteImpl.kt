package com.kienht.gapo.dashboard.data.repository.source.remote

import com.kienht.gapo.dashboard.data.repository.source.remote.api.DashboardApiService
import com.kienht.gapo.dashboard.data.repository.source.remote.model.NewsFeedDTOModel
import javax.inject.Inject

/**
 * @author kienht
 */
internal class DashboardRemoteImpl @Inject constructor(
    private val dashboardApiService: DashboardApiService
) : DashboardRemote {

    /**
     * Fetch data from Github
     */
    override suspend fun fetchNewsFeeds(): List<NewsFeedDTOModel> {
        val response = dashboardApiService.fetchNewsFeeds()
        return response.data ?: emptyList()
    }
}