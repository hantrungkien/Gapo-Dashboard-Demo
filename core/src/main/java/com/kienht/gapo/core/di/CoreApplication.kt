package com.kienht.gapo.core.di

import android.app.Application

/**
 * @author kienht
 * @company OICSoft
 * @since 19/09/2019
 */
abstract class CoreApplication : Application(), CoreComponentProvider {

    private lateinit var coreComponent: CoreComponent

    abstract fun createCoreComponent(): CoreComponent

    override fun provideCoreComponent(): CoreComponent = coreComponent

    override fun onCreate() {
        super.onCreate()

        coreComponent = createCoreComponent()
        coreComponent.inject(this)
    }
}