package com.kienht.gapo.dashboard.news_feed.di

import com.kienht.gapo.core.di.CoreComponent
import com.kienht.gapo.core.di.coreComponent
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
    modules = [NewsFeedModule::class],
    dependencies = [CoreComponent::class]
)
interface NewsFeedComponent : AndroidInjector<NewsFeedFragment> {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            @BindsInstance newsFeedFragment: NewsFeedFragment
        ): NewsFeedComponent
    }
}

fun NewsFeedFragment.inject() {
    DaggerNewsFeedComponent
        .factory()
        .create(coreComponent(), this)
        .inject(this)
}