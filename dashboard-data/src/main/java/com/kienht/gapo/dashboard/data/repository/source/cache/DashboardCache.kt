package com.kienht.gapo.dashboard.data.repository.source.cache

import com.kienht.gapo.dashboard.data.repository.source.cache.model.NewsFeedDAOModel

/**
 * @author kienht
 */
interface DashboardCache {

    companion object {
        const val DASH_BOARD_PREF = "DASH_BOARD_PREF"
    }

    suspend fun fetchNewsFeeds(): List<NewsFeedDAOModel>

    suspend fun saveNewsFeeds(list: List<NewsFeedDAOModel>)
}
