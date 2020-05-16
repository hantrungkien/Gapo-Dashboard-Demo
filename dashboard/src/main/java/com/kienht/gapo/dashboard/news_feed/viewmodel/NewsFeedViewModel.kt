package com.kienht.gapo.dashboard.news_feed.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kienht.gapo.dashboard.news_feed.model.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

/**
 * @author kienht
 * @company OICSoft
 * @since 15/05/2020
 */
class NewsFeedViewModel @Inject constructor(
    private val moshi: Moshi
) : ViewModel() {

    val myAvatarUrl: String =
        "https://scontent.fhan2-2.fna.fbcdn.net/v/t1.0-9/88970319_2805039096243451_3784099829701935104_n.jpg?_nc_cat=106&_nc_sid=85a577&_nc_oc=AQlN0nHIq3zK8_R7fKmssVeXuY9gO5QKVKDpK0bIJXLthOxqsr65Mr7gdrYQa5KgwG8&_nc_ht=scontent.fhan2-2.fna&oh=509bd66f0b376446b79a3072d5cb04af&oe=5EE65222"

    private val post = PostViewData(
        0,
        PostViewData.Type.TEXT,
        "KienHT",
        myAvatarUrl,
        "1 hr",
        myAvatarUrl,
        null,
        null,
        "1.8K",
        "696",
        "123"
    )

    private val postImage = PostViewData(
        1,
        PostViewData.Type.IMAGE,
        "KienHT",
        myAvatarUrl,
        "5 hrs",
        myAvatarUrl,
        listOf(myAvatarUrl),
        null,
        "1.8K",
        "696",
        "123"
    )

    private val postImage2 = PostViewData(
        2,
        PostViewData.Type.IMAGE,
        "KienHT",
        myAvatarUrl,
        "Yesterday at 18:18",
        myAvatarUrl,
        listOf(myAvatarUrl),
        null,
        "10K",
        "6K",
        "123"
    )

    private val postVideo1 = PostViewData(
        3,
        PostViewData.Type.VIDEO,
        "KienHT",
        myAvatarUrl,
        "Yesterday at 18:18",
        myAvatarUrl,
        listOf(myAvatarUrl),
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
        "10K",
        "6K",
        "123"
    )

    private val postVideo2 = PostViewData(
        4,
        PostViewData.Type.VIDEO,
        "KienHT",
        myAvatarUrl,
        "Yesterday at 18:18",
        myAvatarUrl,
        listOf(myAvatarUrl),
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
        "10K",
        "6K",
        "123"
    )

    private val postVideo3 = PostViewData(
        5,
        PostViewData.Type.VIDEO,
        "KienHT",
        myAvatarUrl,
        "Yesterday at 18:18",
        myAvatarUrl,
        listOf(myAvatarUrl),
        "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
        "10K",
        "6K",
        "123"
    )

    private val stories = mutableListOf<StoryViewData>(
        StoryViewData(0, "KienHT", myAvatarUrl, myAvatarUrl),
        StoryViewData(1, "KienHT", myAvatarUrl, myAvatarUrl),
        StoryViewData(2, "KienHT", myAvatarUrl, myAvatarUrl),
        StoryViewData(3, "KienHT", myAvatarUrl, myAvatarUrl),
        StoryViewData(4, "KienHT", myAvatarUrl, myAvatarUrl),
        StoryViewData(5, "KienHT", myAvatarUrl, myAvatarUrl),
        StoryViewData(6, "KienHT", myAvatarUrl, myAvatarUrl),
        StoryViewData(7, "KienHT", myAvatarUrl, myAvatarUrl),
        StoryViewData(8, "KienHT", myAvatarUrl, myAvatarUrl),
        StoryViewData(9, "KienHT", myAvatarUrl, myAvatarUrl),
        StoryViewData(10, "KienHT", myAvatarUrl, myAvatarUrl)
    )

    private val friendRequests = mutableListOf<FriendRequestViewData>(
        FriendRequestViewData(0, "KienHT", myAvatarUrl, 1000),
        FriendRequestViewData(1, "KienHT", myAvatarUrl, 12),
        FriendRequestViewData(2, "KienHT", myAvatarUrl, 34),
        FriendRequestViewData(3, "KienHT", myAvatarUrl, 56),
        FriendRequestViewData(4, "KienHT", myAvatarUrl, 78),
        FriendRequestViewData(5, "KienHT", myAvatarUrl, 87),
        FriendRequestViewData(6, "KienHT", myAvatarUrl, 65),
        FriendRequestViewData(7, "KienHT", myAvatarUrl, 43),
        FriendRequestViewData(8, "KienHT", myAvatarUrl, 21),
        FriendRequestViewData(9, "KienHT", myAvatarUrl, 69),
        FriendRequestViewData(10, "KienHT", myAvatarUrl, 96)
    )

    private val newsfeeds = mutableListOf<NewsFeedViewData>(
        NewsFeedViewData(
            1,
            NewsFeedViewData.Type.STORY,
            stories,
            null,
            null
        ),
        NewsFeedViewData(
            2,
            NewsFeedViewData.Type.POST,
            null,
            post,
            null
        ),
        NewsFeedViewData(
            3,
            NewsFeedViewData.Type.POST,
            null,
            postImage,
            null
        ),
        NewsFeedViewData(
            4,
            NewsFeedViewData.Type.POST,
            null,
            post,
            null
        ),
        NewsFeedViewData(
            5,
            NewsFeedViewData.Type.POST,
            null,
            postVideo1,
            null
        ),
        NewsFeedViewData(
            6,
            NewsFeedViewData.Type.POST,
            null,
            post,
            null
        ),
        NewsFeedViewData(
            7,
            NewsFeedViewData.Type.FRIEND_REQUEST,
            null,
            null,
            friendRequests
        ),
        NewsFeedViewData(
            8,
            NewsFeedViewData.Type.POST,
            null,
            post,
            null
        ),
        NewsFeedViewData(
            9,
            NewsFeedViewData.Type.POST,
            null,
            postVideo2,
            null
        ),
        NewsFeedViewData(
            10,
            NewsFeedViewData.Type.POST,
            null,
            postImage2,
            null
        ),
        NewsFeedViewData(
            11,
            NewsFeedViewData.Type.POST,
            null,
            post,
            null
        ),
        NewsFeedViewData(
            12,
            NewsFeedViewData.Type.POST,
            null,
            postVideo3,
            null
        ),
        NewsFeedViewData(
            13,
            NewsFeedViewData.Type.POST,
            null,
            post,
            null
        ),
        NewsFeedViewData(
            14,
            NewsFeedViewData.Type.POST,
            null,
            post,
            null
        ),
        NewsFeedViewData(
            15,
            NewsFeedViewData.Type.POST,
            null,
            post,
            null
        ),
        NewsFeedViewData(
            16,
            NewsFeedViewData.Type.POST,
            null,
            post,
            null
        ),
        NewsFeedViewData(
            17,
            NewsFeedViewData.Type.POST,
            null,
            post,
            null
        ),
        NewsFeedViewData(
            18,
            NewsFeedViewData.Type.POST,
            null,
            post,
            null
        ),
        NewsFeedViewData(
            19,
            NewsFeedViewData.Type.POST,
            null,
            post,
            null
        ),
        NewsFeedViewData(
            20,
            NewsFeedViewData.Type.POST,
            null,
            post,
            null
        )
    )

    val json: String
        get() {
            val listMyData = Types.newParameterizedType(
                MutableList::class.java,
                NewsFeedViewData::class.java
            )
            val adapter = moshi.adapter<List<NewsFeedViewData>>(listMyData)
            return adapter.toJson(newsfeeds)
        }

    val newsfeedsLiveData: LiveData<List<NewsFeedViewData>>
        get() = _newsfeedsLiveData
    private val _newsfeedsLiveData = NewsFeedsLiveData(newsfeeds)

}