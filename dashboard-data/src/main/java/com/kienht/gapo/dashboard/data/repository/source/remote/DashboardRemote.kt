package com.kienht.gapo.dashboard.data.repository.source.remote

import com.kienht.gapo.dashboard.data.repository.source.remote.model.NewsFeedDTOModel

/**
 * @author kienht
 */
interface DashboardRemote {

    suspend fun fetchNewsFeeds(): List<NewsFeedDTOModel>
}