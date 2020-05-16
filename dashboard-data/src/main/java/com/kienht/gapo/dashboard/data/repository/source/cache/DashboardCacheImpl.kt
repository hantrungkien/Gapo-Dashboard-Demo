package com.kienht.gapo.dashboard.data.repository.source.cache

import android.content.SharedPreferences
import androidx.core.content.edit
import com.kienht.gapo.dashboard.data.repository.source.cache.model.NewsFeedDAOModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.IOException
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 14/05/2020
 */
class DashboardCacheImpl @Inject constructor(
    private val moshi: Moshi,
    private val prefs: SharedPreferences
) : DashboardCache {

    companion object {
        private const val KEY_NEWS_FEEDS = "KEY_NEWS_FEEDS"
        private const val KEY_NEWS_FEEDS_TIME = "KEY_NEWS_FEEDS_TIME"
        private const val ONE_HOUR_TIME_MILLIS = 60 * 60 * 1000
    }

    private val adapter by lazy {
        val type = Types.newParameterizedType(List::class.java, NewsFeedDAOModel::class.java)
        moshi.adapter<List<NewsFeedDAOModel>>(type)
    }

    private val savedTime: Long
        get() = prefs.getLong(KEY_NEWS_FEEDS_TIME, 0L)

    private val isStale: Boolean
        get() = System.currentTimeMillis() - savedTime > ONE_HOUR_TIME_MILLIS

    override suspend fun fetchNewsFeeds(): List<NewsFeedDAOModel> {
        if (isStale) {
            prefs.edit {
                putString(KEY_NEWS_FEEDS, null)
                putLong(KEY_NEWS_FEEDS_TIME, 0)
            }
            return emptyList()
        } else {
            val data = prefs.getString(KEY_NEWS_FEEDS, null) ?: return emptyList()
            return try {
                adapter.fromJson(data) ?: emptyList()
            } catch (e: IOException) {
                emptyList()
            }
        }
    }

    override suspend fun saveNewsFeeds(list: List<NewsFeedDAOModel>) {
        val current = fetchNewsFeeds().toMutableList()
        current.addAll(list)
        val total = current.distinctBy { it.id }
        prefs.edit {
            putString(KEY_NEWS_FEEDS, adapter.toJson(total))
            putLong(KEY_NEWS_FEEDS_TIME, System.currentTimeMillis())
        }
    }
}