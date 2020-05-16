package com.kienht.gapo.dashboard.data.repository

import android.util.Log
import com.kienht.gapo.dashboard.data.repository.source.cache.DashboardCache
import com.kienht.gapo.dashboard.data.repository.source.cache.model.mapToCached
import com.kienht.gapo.dashboard.data.repository.source.cache.model.mapToDomain
import com.kienht.gapo.dashboard.data.repository.source.remote.DashboardRemote
import com.kienht.gapo.dashboard.data.repository.source.remote.model.mapToDomain
import com.kienht.gapo.dashboard.domain.usecase.news.model.NewsFeed
import com.kienht.gapo.dashboard.domain.usecase.news.repository.DashboardRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge

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

    @ExperimentalCoroutinesApi
    override fun newsFeedsFlow(): Flow<List<NewsFeed>> {
        val cacheFlow = flow<List<NewsFeed>> {
            val list = dashboardCache.fetchNewsFeeds().mapToDomain()
            emit(list)
        }.catch {
            Log.e("DashboardRepository", "newsFeedsFlow: cacheFlow => error")
        }
        val remoteFlow = flow<List<NewsFeed>> {
            val data = dashboardRemote.fetchNewsFeeds().mapToDomain()
            dashboardCache.saveNewsFeeds(data.mapToCached())
            val list = dashboardCache.fetchNewsFeeds().mapToDomain()
            emit(list)
        }.catch {
            Log.e("DashboardRepository", "newsFeedsFlow: remoteFlow => error")
        }
        return merge(cacheFlow, remoteFlow)
    }
}