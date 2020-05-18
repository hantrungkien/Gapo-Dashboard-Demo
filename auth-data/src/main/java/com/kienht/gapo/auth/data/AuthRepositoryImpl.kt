package com.kienht.gapo.auth.data

import com.kienht.gapo.auth.data.source.cache.AuthCache
import com.kienht.gapo.auth.data.source.remote.AuthRemote
import com.kienht.gapo.auth.domain.repository.AuthRepository
import javax.inject.Inject

/**
 * @author kienht
 */
internal class AuthRepositoryImpl constructor(
    private val authCache: AuthCache,
    private val authRemote: AuthRemote
) : AuthRepository {

    companion object {
        @Volatile
        private var INSTANCE: AuthRepository? = null

        @JvmStatic
        fun getInstance(
            authCache: AuthCache,
            authRemote: AuthRemote
        ): AuthRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: AuthRepositoryImpl(
                    authCache,
                    authRemote
                ).also { INSTANCE = it }
            }
        }
    }

    /**
     * Kiểm tra xem đã login hay chưa?
     */
    override val isLoggedIn: Boolean
        get() = authCache.isLoggedIn
            .also {
                if (!it) {
                    logout()
                }
            }

    /**
     * Sau khi login thành công sẽ lưu dữ liệu xuống cache.
     */
    override suspend fun login(phone: String) {
        authRemote.login(phone)
        authCache.setLoggedInUser()
    }

    /**
     * Xoá dữ liệu cache và token ở remote.
     */
    override fun logout() {
        authCache.logout()
        authRemote.logout()
    }
}
