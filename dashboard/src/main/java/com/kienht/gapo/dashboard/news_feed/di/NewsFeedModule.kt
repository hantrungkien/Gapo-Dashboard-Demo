package com.kienht.gapo.dashboard.news_feed.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kienht.gapo.core.common.ViewModelFactory
import com.kienht.gapo.core.di.common.ViewModelKey
import com.kienht.gapo.dashboard.news_feed.NewsFeedFragment
import com.kienht.gapo.dashboard.news_feed.viewmodel.NewsFeedViewModel
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
abstract class NewsFeedModule {

    @Binds
    @FeatureScope
    abstract fun bindNewsFeedFragment(newsFeedFragment: NewsFeedFragment): Fragment

    @Binds
    @FeatureScope
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NewsFeedViewModel::class)
    abstract fun bindNewsFeedViewModel(newsFeedViewModel: NewsFeedViewModel): ViewModel
}