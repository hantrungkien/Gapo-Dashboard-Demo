package com.kienht.gapo.dashboard.domain.usecase.news.repository

import com.kienht.gapo.dashboard.domain.usecase.news.model.NewsFeeds
import kotlinx.coroutines.flow.Flow

/**
 * @author kienht
 */
interface DashboardRepository {

    fun newsFeedsFlow(): Flow<List<NewsFeeds>>

}