package com.kienht.gapo.dashboard.data.repository

import com.kienht.gapo.dashboard.data.repository.source.cache.DashboardCache
import com.kienht.gapo.dashboard.data.repository.source.remote.DashboardRemote
import com.kienht.gapo.dashboard.domain.usecase.news.repository.DashboardRepository

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
internal class DashboardRepositoryImpl(
    private val dashboardCache: DashboardCache,
    private val dashboardRemote: DashboardRemote
) : DashboardRepository {

    companion object {
        @Volatile
        private var INSTANCE: DashboardRepository? = null

        @JvmStatic
        fun getInstance(
            dashboardCache: DashboardCache,
            dashboardRemote: DashboardRemote
        ): DashboardRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: DashboardRepositoryImpl(
                    dashboardCache,
                    dashboardRemote
                ).also { INSTANCE = it }
            }
        }
    }
}