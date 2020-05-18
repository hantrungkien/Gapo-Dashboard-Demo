package com.kienht.gapo.post_details.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kienht.gapo.core.common.ViewModelFactory
import com.kienht.gapo.core.di.common.ViewModelKey
import com.kienht.gapo.post_details.PostDetailsActivity
import com.kienht.gapo.post_details.viewmodel.PostDetailsViewModel
import com.kienht.gapo.shared.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author kienht
 */
@Module
abstract class PostDetailsModule {

    @Binds
    @FeatureScope
    abstract fun bindPostDetailsActivity(postDetailsActivity: PostDetailsActivity): AppCompatActivity

    @Binds
    @FeatureScope
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PostDetailsViewModel::class)
    abstract fun bindPostDetailsViewModel(postDetailsViewModel: PostDetailsViewModel): ViewModel
}