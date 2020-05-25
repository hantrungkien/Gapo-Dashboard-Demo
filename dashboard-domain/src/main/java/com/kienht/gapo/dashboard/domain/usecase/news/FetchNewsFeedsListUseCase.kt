package com.kienht.gapo.dashboard.domain.usecase.news

import com.kienht.gapo.dashboard.domain.usecase.news.model.NewsFeeds
import com.kienht.gapo.dashboard.domain.usecase.news.repository.DashboardRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/**
 * @author kienht
 */
class FetchNewsFeedsListUseCase @Inject constructor(
    private val dashboardRepository: DashboardRepository
) {

    operator fun invoke(): Flow<List<NewsFeeds>> {
        return dashboardRepository.newsFeedsFlow()
    }
}
