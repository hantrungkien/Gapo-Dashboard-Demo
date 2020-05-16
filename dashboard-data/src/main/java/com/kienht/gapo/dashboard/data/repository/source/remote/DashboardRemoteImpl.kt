package com.kienht.gapo.dashboard.data.repository.source.remote

import com.kienht.gapo.dashboard.data.repository.source.remote.api.DashboardApiService
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
internal class DashboardRemoteImpl @Inject constructor(
    private val dashboardApiService: DashboardApiService
) : DashboardRemote {
}