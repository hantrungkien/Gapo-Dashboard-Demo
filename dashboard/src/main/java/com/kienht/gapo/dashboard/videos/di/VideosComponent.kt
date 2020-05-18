package com.kienht.gapo.dashboard.videos.di

import com.kienht.gapo.core.di.CoreComponent
import com.kienht.gapo.core.di.coreComponent
import com.kienht.gapo.dashboard.videos.VideosFragment
import com.kienht.gapo.shared.FeatureScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

/**
 * @author kienht
 */
@FeatureScope
@Component(
    modules = [VideosModule::class],
    dependencies = [CoreComponent::class]
)
interface VideosComponent : AndroidInjector<VideosFragment> {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            @BindsInstance videosFragment: VideosFragment
        ): VideosComponent
    }
}

fun VideosFragment.inject() {
    DaggerVideosComponent
        .factory()
        .create(coreComponent(), this)
        .inject(this)
}