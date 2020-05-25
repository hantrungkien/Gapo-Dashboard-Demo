package com.kienht.gapo.core.di.module

import android.app.Application
import com.kienht.gapo.core.di.CoreApplication
import com.kienht.gapo.shared.qualifier.DebugModeQualifier
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * @author kienht
 */

@Module
abstract class CoreModule {

    @Binds
    @Singleton
    internal abstract fun bindApplication(app: CoreApplication): Application

    companion object {
        @Provides
        @Singleton
        internal fun provideMoshi(): Moshi {
            return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        }

        @Provides
        internal fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder().addInterceptor(interceptor).build()

        @Provides
        internal fun provideLoggingInterceptor(
            @DebugModeQualifier isDebug: Boolean
        ): HttpLoggingInterceptor = HttpLoggingInterceptor()
                .apply {
                level = if (isDebug) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }
    }
}
