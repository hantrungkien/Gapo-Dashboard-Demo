package com.kienht.gapo.auth.data.source.remote.api

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @author kienht
 */
internal interface AuthApiService {

    companion object {
        const val BASE_URL = "https://api.gapo.vn/v1/rest/"
    }

    @POST("auth/login")
    @FormUrlEncoded
    suspend fun login(@Field("phone") phone: String)
}