package com.kienht.gapo.auth.data.source.remote

import android.content.SharedPreferences
import androidx.core.content.edit
import com.kienht.gapo.auth.data.source.remote.api.AuthApiService
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
internal class AuthRemoteImpl @Inject constructor(
    private val authApiService: AuthApiService,
    private val prefs: SharedPreferences
) : AuthRemote {

    companion object {
        private const val KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN"
    }

    var token: String? = null
        get() = prefs.getString(KEY_ACCESS_TOKEN, null)
        set(value) {
            prefs.edit { putString(KEY_ACCESS_TOKEN, value) }
            field = value
        }

    override suspend fun login(phone: String) {
        try {
            authApiService.login(phone)
        } catch (e: Exception) {
        } finally {
            token = "Token-Token-Token"
        }
    }

    override fun logout() {
        token = null
    }
}


