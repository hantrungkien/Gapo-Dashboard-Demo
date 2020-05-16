package com.kienht.gapo.dashboard.menu.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kienht.gapo.core.common.ViewModelFactory
import com.kienht.gapo.core.di.common.ViewModelKey
import com.kienht.gapo.dashboard.menu.MenuFragment
import com.kienht.gapo.dashboard.menu.viewmodel.MenuViewModel
import com.kienht.gapo.shared.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
@Module
abstract class MenuModule {

    @Binds
    @FeatureScope
    abstract fun bindMenuFragment(menuFragment: MenuFragment): Fragment

    @Binds
    @FeatureScope
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun bindMenuViewModel(menuViewModel: MenuViewModel): ViewModel
}