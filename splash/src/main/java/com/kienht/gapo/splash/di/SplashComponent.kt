package com.kienht.gapo.splash.di

import com.kienht.gapo.core.di.CoreComponent
import com.kienht.gapo.core.di.coreComponent
import com.kienht.gapo.shared.FeatureScope
import com.kienht.gapo.splash.SplashActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

/**
 * @author kienht
 */
@FeatureScope
@Component(
    modules = [SplashModule::class],
    dependencies = [CoreComponent::class]
)
internal interface SplashComponent : AndroidInjector<SplashActivity> {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            @BindsInstance splashActivity: SplashActivity
        ): SplashComponent
    }
}

internal fun SplashActivity.inject() {
    DaggerSplashComponent
        .factory()
        .create(coreComponent(), this)
        .inject(this)
}