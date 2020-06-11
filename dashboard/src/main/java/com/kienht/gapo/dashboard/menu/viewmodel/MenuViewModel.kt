package com.kienht.gapo.dashboard.menu.viewmodel

import androidx.lifecycle.*
import com.kienht.gapo.dashboard.domain.usecase.news.FetchNewsFeedsListUseCase
import com.kienht.gapo.dashboard.news_feeds.model.NewsFeedViewData
import com.kienht.gapo.dashboard.news_feeds.model.mapToViewData
import com.kienht.gapo.shared.qualifier.CoDispatcherIOQualifier
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import javax.inject.Inject

/**
 * @author kienht
 */
class MenuViewModel @Inject constructor(
    fetchNewsFeedsListUseCase: FetchNewsFeedsListUseCase,
    @CoDispatcherIOQualifier private val executor: CoroutineDispatcher
) : ViewModel() {

    val newsFeedsLiveData: LiveData<List<NewsFeedViewData>> = fetchNewsFeedsListUseCase()
        .filter { it.isNotEmpty() }
        .map { it.mapToViewData() }
        .asLiveData(viewModelScope.coroutineContext + executor)
}