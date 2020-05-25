package com.kienht.gapo.auth.data.di

import com.kienht.gapo.auth.data.AuthRepositoryImpl
import com.kienht.gapo.auth.data.source.cache.AuthCache
import com.kienht.gapo.auth.data.source.cache.AuthCacheImpl
import com.kienht.gapo.auth.data.source.remote.AuthRemote
import com.kienht.gapo.auth.data.source.remote.AuthRemoteImpl
import com.kienht.gapo.auth.data.source.remote.api.AuthApiService
import com.kienht.gapo.shared.FeatureScope
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Lazy
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * @author kienht
 */
@Module
abstract class AuthDataModule {

    @Binds
    @FeatureScope
    internal abstract fun bindAuthRemote(authRemote: AuthRemoteImpl): AuthRemote

    @Binds
    @FeatureScope
    internal abstract fun bindAuthCache(authCache: AuthCacheImpl): AuthCache

    companion object {

        @Provides
        @FeatureScope
        internal fun provideAuthRepository(
            authCache: AuthCache,
            authRemote: AuthRemote
        ) = AuthRepositoryImpl.getInstance(authCache, authRemote)

        @Provides
        @FeatureScope
        internal fun provideAuthApiService(
            client: Lazy<OkHttpClient>,
            moshi: Moshi
        ) = Retrofit.Builder()
            .baseUrl(AuthApiService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client.get())
            .build()
            .create(AuthApiService::class.java)
    }
}
