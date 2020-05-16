package com.kienht.gapo.dashboard.data.di

import com.kienht.gapo.dashboard.data.repository.DashboardRepositoryImpl
import com.kienht.gapo.dashboard.data.repository.source.cache.DashboardCache
import com.kienht.gapo.dashboard.data.repository.source.cache.DashboardCacheImpl
import com.kienht.gapo.dashboard.data.repository.source.remote.DashboardRemote
import com.kienht.gapo.dashboard.data.repository.source.remote.DashboardRemoteImpl
import com.kienht.gapo.shared.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
@Module
abstract class DashboardDataModule {

    @Binds
    @FeatureScope
    internal abstract fun bindDashboardRemote(authRemote: DashboardRemoteImpl): DashboardRemote

    @Binds
    @FeatureScope
    internal abstract fun bindDashboardCache(authCache: DashboardCacheImpl): DashboardCache

    companion object {

        @Provides
        @FeatureScope
        internal fun provideDashboardRepository(
            dashboardCache: DashboardCache,
            dashboardRemote: DashboardRemote
        ) = DashboardRepositoryImpl.getInstance(dashboardCache, dashboardRemote)
    }
}