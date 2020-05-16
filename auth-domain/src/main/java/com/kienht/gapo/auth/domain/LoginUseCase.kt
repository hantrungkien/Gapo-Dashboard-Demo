package com.kienht.gapo.auth.domain

import com.kienht.gapo.auth.domain.repository.AuthRepository
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    val isLoggedIn: Boolean
        get() = authRepository.isLoggedIn

    suspend operator fun invoke(phone: String) {
        authRepository.login(phone)
    }

    fun logout() = authRepository.logout()
}