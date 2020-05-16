package com.kienht.gapo.dashboard.news_feed.viewmodel

import androidx.lifecycle.*
import com.kienht.gapo.core.common.DataState
import com.kienht.gapo.dashboard.domain.usecase.news.FetchNewsFeedsListUseCase
import com.kienht.gapo.dashboard.news_feed.model.*
import com.kienht.gapo.shared.qualifier.CoDispatcherIOQualifier
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
class NewsFeedViewModel @Inject constructor(
    private val fetchNewsFeedsListUseCase: FetchNewsFeedsListUseCase,
    @CoDispatcherIOQualifier private val executor: CoroutineDispatcher
) : ViewModel() {

    val myAvatarUrl: String =
        "https://github.com/hantrungkien/Gapo-Dashboard-Demo/blob/master/images/avatar/xuan_lan.jpg"

    private val action = MutableLiveData<Unit?>()

    val newsFeedsLiveData: LiveData<List<NewsFeedViewData>>
        get() = _newsFeedsLiveData
    private val _newsFeedsLiveData = NewsFeedsLiveData(emptyList())

    val dataState: LiveData<DataState<List<NewsFeedViewData>>> = action.switchMap {
        liveData(viewModelScope.coroutineContext + executor) {
            emit(DataState.LOADING)
            try {
                val newsFeeds = fetchNewsFeedsListUseCase().mapToViewData()
                _newsFeedsLiveData.postValue(newsFeeds)
                emit(DataState.SUCCESS(newsFeeds))
            } catch (exception: Exception) {
                emit(DataState.ERROR(exception))
            }
        }
    }

    fun fetch() {
        action.value = null
    }
}