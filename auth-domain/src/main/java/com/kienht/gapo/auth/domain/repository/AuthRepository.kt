package com.kienht.gapo.auth.domain.repository

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
interface AuthRepository {

    val isLoggedIn: Boolean

    suspend fun login(phone: String)

    fun logout()

}