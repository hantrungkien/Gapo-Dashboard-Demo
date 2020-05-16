package com.kienht.gapo.dashboard.domain.usecase.news

import com.kienht.gapo.dashboard.domain.usecase.news.model.NewsFeed
import com.kienht.gapo.dashboard.domain.usecase.news.repository.DashboardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
class FetchNewsFeedsListUseCase @Inject constructor(
    private val dashboardRepository: DashboardRepository
) {

    operator fun invoke(): Flow<List<NewsFeed>> {
        return dashboardRepository.newsFeedsFlow()
    }
}