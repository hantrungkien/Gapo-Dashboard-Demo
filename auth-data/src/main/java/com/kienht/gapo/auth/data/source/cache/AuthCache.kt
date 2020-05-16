package com.kienht.gapo.auth.data.source.cache

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
interface AuthCache {

    companion object {
        const val AUTH_PREF = "AUTH_PREF"
    }

    val isLoggedIn: Boolean

    fun setLoggedInUser()

    fun logout()
}