package com.kienht.gapo.auth.data.source.remote

/**
 * @author kienht
 */
internal interface AuthRemote {

    suspend fun login(phone: String)

    fun logout()
}