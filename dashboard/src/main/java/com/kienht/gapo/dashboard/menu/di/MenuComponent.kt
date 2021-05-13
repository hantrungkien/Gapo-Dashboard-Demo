package com.kienht.gapo.dashboard.menu.di

import com.kienht.gapo.core.di.CoreComponent
import com.kienht.gapo.core.di.coreComponent
import com.kienht.gapo.core.di.module.SharedPreferencesModule
import com.kienht.gapo.dashboard.data.di.DashboardDataModule
import com.kienht.gapo.dashboard.data.repository.source.cache.DashboardCache
import com.kienht.gapo.dashboard.menu.MenuFragment
import com.kienht.gapo.shared.FeatureScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

/**
 * @author kienht
 */
@FeatureScope
@Component(
    modules = [MenuModule::class, DashboardDataModule::class, SharedPreferencesModule::class],
    dependencies = [CoreComponent::class]
)
interface MenuComponent : AndroidInjector<MenuFragment> {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            module: SharedPreferencesModule,
            @BindsInstance menuFragment: MenuFragment
        ): MenuComponent
    }
}

fun MenuFragment.inject() {
    DaggerMenuComponent
        .factory()
        .create(coreComponent(),
            SharedPreferencesModule(requireContext(), DashboardCache.DASH_BOARD_PREF),
            this)
        .inject(this)
}