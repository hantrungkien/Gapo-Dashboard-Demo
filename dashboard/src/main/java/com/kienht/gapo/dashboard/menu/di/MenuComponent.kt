package com.kienht.gapo.dashboard.menu.di

import com.kienht.gapo.core.di.CoreComponent
import com.kienht.gapo.core.di.coreComponent
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
    modules = [MenuModule::class],
    dependencies = [CoreComponent::class]
)
interface MenuComponent : AndroidInjector<MenuFragment> {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            @BindsInstance menuFragment: MenuFragment
        ): MenuComponent
    }
}

fun MenuFragment.inject() {
    DaggerMenuComponent
        .factory()
        .create(coreComponent(), this)
        .inject(this)
}
