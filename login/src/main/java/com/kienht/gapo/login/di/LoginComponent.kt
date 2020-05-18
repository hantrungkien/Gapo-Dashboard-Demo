package com.kienht.gapo.login.di

import com.kienht.gapo.auth.data.di.AuthDataModule
import com.kienht.gapo.auth.data.source.cache.AuthCache
import com.kienht.gapo.core.di.CoreComponent
import com.kienht.gapo.core.di.coreComponent
import com.kienht.gapo.core.di.module.SharedPreferencesModule
import com.kienht.gapo.login.LoginActivity
import com.kienht.gapo.shared.FeatureScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

/**
 * @author kienht
 */
@FeatureScope
@Component(
    modules = [LoginModule::class,
        SharedPreferencesModule::class,
        AuthDataModule::class],
    dependencies = [CoreComponent::class]
)
interface LoginComponent : AndroidInjector<LoginActivity> {

    @Component.Factory
    interface Factory {

        fun create(
            coreComponent: CoreComponent,
            module: SharedPreferencesModule,
            @BindsInstance loginActivity: LoginActivity
        ): LoginComponent
    }
}

fun LoginActivity.inject() {
    DaggerLoginComponent
        .factory()
        .create(
            coreComponent(),
            SharedPreferencesModule(this, AuthCache.AUTH_PREF),
            this
        )
        .inject(this)
}