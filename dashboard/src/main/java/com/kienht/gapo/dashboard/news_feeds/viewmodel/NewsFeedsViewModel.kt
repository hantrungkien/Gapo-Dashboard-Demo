package com.kienht.gapo.dashboard.news_feeds.viewmodel

import androidx.lifecycle.*
import com.kienht.gapo.dashboard.domain.usecase.news.FetchNewsFeedsListUseCase
import com.kienht.gapo.dashboard.news_feeds.model.*
import com.kienht.gapo.shared.qualifier.CoDispatcherIOQualifier
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
class NewsFeedsViewModel @Inject constructor(
    fetchNewsFeedsListUseCase: FetchNewsFeedsListUseCase,
    @CoDispatcherIOQualifier private val executor: CoroutineDispatcher
) : ViewModel() {

    val myAvatarUrl: String = "https://i.ibb.co/frD0Thn/avatar-kienht.jpg"

    val newsFeedsLiveData: LiveData<List<NewsFeedViewData>> = fetchNewsFeedsListUseCase()
        .filter { it.isNotEmpty() }
        .map { it.mapToViewData() }
        .asLiveData(viewModelScope.coroutineContext + executor)
}