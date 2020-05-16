package com.kienht.gapo.core.di.module

import android.content.Context
import android.content.SharedPreferences
import com.kienht.gapo.shared.FeatureScope
import dagger.Module
import dagger.Provides

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
@Module
open class SharedPreferencesModule(val context: Context, val name: String) {

    @Provides
    @FeatureScope
    fun provideSharedPreferences(): SharedPreferences {
        return context.applicationContext.getSharedPreferences(name, Context.MODE_PRIVATE)
    }
}