package com.kienht.gapo

import android.content.Context
import androidx.multidex.MultiDex
import com.kienht.gapo.core.di.CoreApplication
import com.kienht.gapo.core.di.CoreComponent
import com.kienht.gapo.core.di.DaggerCoreComponent
import com.kienht.gapo.core.di.module.ConstantsModule

/**
 * @author kienht
 */
class GapoApplication : CoreApplication() {

    override fun createCoreComponent(): CoreComponent {
        return DaggerCoreComponent
            .factory()
            .create(
                ConstantsModule(
                    BuildConfig.APPLICATION_ID,
                    BuildConfig.DEBUG
                ),
                this as CoreApplication
            )
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}