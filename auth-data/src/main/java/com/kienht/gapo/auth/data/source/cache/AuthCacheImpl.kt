package com.kienht.gapo.auth.data.source.cache

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

/**
 * @author kienht
 */
internal class AuthCacheImpl @Inject constructor(
    private val prefs: SharedPreferences
) : AuthCache {

    companion object {
        private const val KEY_LOGGED = "KEY_LOGGED"
        private const val KEY_LOGGED_TIME = "KEY_LOGGED_TIME"
        private const val ONE_WEEK_TIME_MILLIS = 7 * 24 * 60 * 60 * 1000
    }

    private val loggedTime: Long
        get() = prefs.getLong(KEY_LOGGED_TIME, 0L)

    /**
     * Kiểm tra thời hạn session login đã quá 1 tuần hay chưa?
     */
    private val isStale: Boolean
        get() = System.currentTimeMillis() - loggedTime > ONE_WEEK_TIME_MILLIS

    override val isLoggedIn: Boolean
        get() = prefs.getBoolean(KEY_LOGGED, false) && !isStale

    override fun setLoggedInUser() {
        prefs.edit {
            putBoolean(KEY_LOGGED, true)
            putLong(KEY_LOGGED_TIME, System.currentTimeMillis())
        }
    }

    override fun logout() {
        prefs.edit {
            putBoolean(KEY_LOGGED, false)
            putLong(KEY_LOGGED_TIME, 0L)
        }
    }
}
