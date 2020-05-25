package com.kienht.gapo.post_details.di

import com.kienht.gapo.core.di.CoreComponent
import com.kienht.gapo.core.di.coreComponent
import com.kienht.gapo.post_details.PostDetailsActivity
import com.kienht.gapo.shared.FeatureScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

/**
 * @author kienht
 */
@FeatureScope
@Component(
    modules = [PostDetailsModule::class],
    dependencies = [CoreComponent::class]
)
interface PostDetailsComponent : AndroidInjector<PostDetailsActivity> {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            @BindsInstance postDetailsActivity: PostDetailsActivity
        ): PostDetailsComponent
    }
}

fun PostDetailsActivity.inject() {
    DaggerPostDetailsComponent
        .factory()
        .create(coreComponent(), this)
        .inject(this)
}
