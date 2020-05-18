package com.kienht.gapo.auth.domain.repository

/**
 * @author kienht
 */
interface AuthRepository {

    val isLoggedIn: Boolean

    suspend fun login(phone: String)

    fun logout()

}