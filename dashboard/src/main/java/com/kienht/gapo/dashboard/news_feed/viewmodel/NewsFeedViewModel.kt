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
        "https://scontent.fhan2-2.fna.fbcdn.net/v/t1.0-9/88970319_2805039096243451_3784099829701935104_n.jpg?_nc_cat=106&_nc_sid=85a577&_nc_oc=AQlN0nHIq3zK8_R7fKmssVeXuY9gO5QKVKDpK0bIJXLthOxqsr65Mr7gdrYQa5KgwG8&_nc_ht=scontent.fhan2-2.fna&oh=509bd66f0b376446b79a3072d5cb04af&oe=5EE65222"

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