package com.kienht.gapo.dashboard.data.repository.source.remote

import com.kienht.gapo.dashboard.data.repository.source.remote.model.NewsFeedDTOModel

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
interface DashboardRemote {

    suspend fun fetchNewsFeeds(): List<NewsFeedDTOModel>
}