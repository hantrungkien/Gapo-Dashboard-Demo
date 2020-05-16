package com.kienht.gapo.dashboard.news_feed.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kienht.gapo.dashboard.news_feed.model.NewsFeedViewData
import com.kienht.gapo.dashboard.news_feed.model.NewsFeedsLiveData
import com.kienht.gapo.dashboard.news_feed.model.PostViewData
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
class NewsFeedViewModel @Inject constructor() : ViewModel() {

    val myAvatarUrl: String =
        "https://scontent.fhan2-2.fna.fbcdn.net/v/t1.0-9/88970319_2805039096243451_3784099829701935104_n.jpg?_nc_cat=106&_nc_sid=85a577&_nc_oc=AQlN0nHIq3zK8_R7fKmssVeXuY9gO5QKVKDpK0bIJXLthOxqsr65Mr7gdrYQa5KgwG8&_nc_ht=scontent.fhan2-2.fna&oh=509bd66f0b376446b79a3072d5cb04af&oe=5EE65222"

    private val newsfeeds = mutableListOf<NewsFeedViewData>(
        NewsFeedViewData(
            1,
            NewsFeedViewData.Type.POST,
            null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            2,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            3,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            4,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            5,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            6,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            7,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            8,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            9,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            10,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            11,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            12,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            13,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            14,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            15,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            16,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            17,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            18,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            19,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        ),
        NewsFeedViewData(
            20,
            NewsFeedViewData.Type.POST, null,
            PostViewData(0, PostViewData.Type.TEXT, "KienHT", ""),
            null
        )
    )

    val newsfeedsLiveData: LiveData<List<NewsFeedViewData>>
        get() = _newsfeedsLiveData
    private val _newsfeedsLiveData = NewsFeedsLiveData(newsfeeds)

}