package com.kienht.gapo.dashboard.domain.usecase.news.repository

import com.kienht.gapo.dashboard.domain.usecase.news.model.NewsFeed

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
interface DashboardRepository {

    suspend fun fetchNewsFeeds(): List<NewsFeed>

}