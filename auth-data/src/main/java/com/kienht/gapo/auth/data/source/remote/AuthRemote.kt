package com.kienht.gapo.auth.data.source.remote

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
internal interface AuthRemote {

    suspend fun login(phone: String)

    fun logout()
}