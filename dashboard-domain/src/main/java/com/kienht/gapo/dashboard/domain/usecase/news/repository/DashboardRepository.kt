package com.kienht.gapo.dashboard.domain.usecase.news.repository

import com.kienht.gapo.dashboard.domain.usecase.news.model.NewsFeeds
import kotlinx.coroutines.flow.Flow

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
interface DashboardRepository {

    fun newsFeedsFlow(): Flow<List<NewsFeeds>>

}