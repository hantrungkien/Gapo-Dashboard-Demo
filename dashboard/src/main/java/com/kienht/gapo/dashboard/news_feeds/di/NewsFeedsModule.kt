package com.kienht.gapo.dashboard.news_feeds.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kienht.gapo.core.common.ViewModelFactory
import com.kienht.gapo.core.di.common.ViewModelKey
import com.kienht.gapo.dashboard.news_feeds.NewsFeedsFragment
import com.kienht.gapo.dashboard.news_feeds.viewmodel.NewsFeedsViewModel
import com.kienht.gapo.shared.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author kienht
 */
@Module
abstract class NewsFeedsModule {

    @Binds
    @FeatureScope
    abstract fun bindNewsFeedsFragment(newsFeedsFragment: NewsFeedsFragment): Fragment

    @Binds
    @FeatureScope
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NewsFeedsViewModel::class)
    abstract fun bindNewsFeedsViewModel(newsFeedsViewModel: NewsFeedsViewModel): ViewModel
}
