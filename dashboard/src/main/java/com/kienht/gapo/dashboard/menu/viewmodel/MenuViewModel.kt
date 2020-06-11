package com.kienht.gapo.dashboard.menu.viewmodel

import androidx.lifecycle.*
import com.kienht.gapo.dashboard.domain.usecase.news.FetchNewsFeedsListUseCase
import com.kienht.gapo.dashboard.news_feeds.model.NewsFeedViewData
import com.kienht.gapo.dashboard.news_feeds.model.mapToViewData
import com.kienht.gapo.shared.qualifier.CoDispatcherIOQualifier
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author kienht
 */
class MenuViewModel @Inject constructor(
    private val fetchNewsFeedsListUseCase: FetchNewsFeedsListUseCase,
    @CoDispatcherIOQualifier private val executor: CoroutineDispatcher
) : ViewModel() {

    private var list = mutableListOf<NewsFeedViewData>()

    private val _newsFeedsLiveData = MutableLiveData<List<NewsFeedViewData>>()

    val newsFeedsLiveData: MutableLiveData<List<NewsFeedViewData>>
        get() = _newsFeedsLiveData

    fun fetchNotification() {
        viewModelScope.launch {
            withContext(executor) {
                fetchNewsFeedsListUseCase()
                    .filter { it.isNotEmpty() }
                    .map { it.mapToViewData() }
                    .collect {
                        list.addAll(it)
                        _newsFeedsLiveData.postValue(it)
                    }
            }
        }
    }

    fun loadmore() {
        viewModelScope.launch {
            withContext(executor) {
                fetchNewsFeedsListUseCase()
                    .map { it.mapToViewData() }
                    .collect {
                        list.addAll(it)
                        _newsFeedsLiveData.postValue(list)
                    }
            }
        }
    }
}