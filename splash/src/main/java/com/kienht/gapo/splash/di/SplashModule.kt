package com.kienht.gapo.splash.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kienht.gapo.core.common.ViewModelFactory
import com.kienht.gapo.core.di.common.ViewModelKey
import com.kienht.gapo.shared.FeatureScope
import com.kienht.gapo.splash.SplashActivity
import com.kienht.gapo.splash.viewmodel.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author kienht
 */
@Module
internal abstract class SplashModule {

    @Binds
    @FeatureScope
    abstract fun bindSplashActivity(splashActivity: SplashActivity): AppCompatActivity

    @Binds
    @FeatureScope
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel
}