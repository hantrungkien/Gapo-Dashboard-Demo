package com.kienht.gapo.dashboard.videos.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kienht.gapo.core.common.ViewModelFactory
import com.kienht.gapo.core.di.common.ViewModelKey
import com.kienht.gapo.dashboard.videos.VideosFragment
import com.kienht.gapo.dashboard.videos.viewmodel.VideosViewModel
import com.kienht.gapo.shared.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author kienht
 */
@Module
abstract class VideosModule {

    @Binds
    @FeatureScope
    abstract fun bindVideosFragment(videosFragment: VideosFragment): Fragment

    @Binds
    @FeatureScope
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(VideosViewModel::class)
    abstract fun bindVideosViewModel(videosViewModel: VideosViewModel): ViewModel
}
