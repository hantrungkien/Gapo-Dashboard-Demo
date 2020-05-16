package com.kienht.gapo.dashboard.news_feed.di

import com.kienht.gapo.core.di.CoreComponent
import com.kienht.gapo.core.di.coreComponent
import com.kienht.gapo.core.di.module.SharedPreferencesModule
import com.kienht.gapo.dashboard.data.di.DashboardDataModule
import com.kienht.gapo.dashboard.data.repository.source.cache.DashboardCache
import com.kienht.gapo.dashboard.di.inject
import com.kienht.gapo.dashboard.news_feed.NewsFeedFragment
import com.kienht.gapo.shared.FeatureScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
@FeatureScope
@Component(
    modules = [NewsFeedModule::class, DashboardDataModule::class, SharedPreferencesModule::class],
    dependencies = [CoreComponent::class]
)
interface NewsFeedComponent : AndroidInjector<NewsFeedFragment> {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            module: SharedPreferencesModule,
            @BindsInstance newsFeedFragment: NewsFeedFragment
        ): NewsFeedComponent
    }
}

fun NewsFeedFragment.inject() {
    DaggerNewsFeedComponent
        .factory()
        .create(
            coreComponent(),
            SharedPreferencesModule(requireContext(), DashboardCache.DASH_BOARD_PREF),
            this
        )
        .inject(this)
}