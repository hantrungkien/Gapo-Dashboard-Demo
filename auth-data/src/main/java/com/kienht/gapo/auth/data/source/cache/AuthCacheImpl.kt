package com.kienht.gapo.auth.data.source.cache

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
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

    private val isStale: Boolean
        get() = System.currentTimeMillis() - loggedTime > ONE_WEEK_TIME_MILLIS

    override fun setLoggedInUser() {
        prefs.edit {
            putBoolean(KEY_LOGGED, true)
            putLong(KEY_LOGGED_TIME, System.currentTimeMillis())
        }
    }

    override val isLoggedIn: Boolean
        get() = prefs.getBoolean(KEY_LOGGED, false) && !isStale

    override fun logout() {
        prefs.edit {
            putBoolean(KEY_LOGGED, false)
            putLong(KEY_LOGGED_TIME, 0L)
        }
    }
}