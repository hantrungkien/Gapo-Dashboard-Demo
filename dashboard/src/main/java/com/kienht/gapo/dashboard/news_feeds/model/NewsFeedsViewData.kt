package com.kienht.gapo.dashboard.news_feeds.model

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import com.kienht.gapo.dashboard.domain.usecase.news.model.NewsFeeds
import kotlinx.android.parcel.Parcelize

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */

class NewsFeedsLiveData(posts: List<NewsFeedViewData>) :
    MutableLiveData<List<NewsFeedViewData>>(posts) {

    override fun setValue(value: List<NewsFeedViewData>) {
        super.setValue(value.copy())
    }

    override fun postValue(value: List<NewsFeedViewData>) {
        super.postValue(value.copy())
    }

    private fun List<NewsFeedViewData>.copy() = this.map { it.copy() }

}

@Parcelize
data class NewsFeedViewData(
    val id: Long,
    val type: NewsFeeds.Type,
    val stories: List<StoryViewData>?,
    val post: PostViewData?,
    val friendRequests: List<FriendRequestViewData>?
) : Parcelable {

    object DiffItemCallback : DiffUtil.ItemCallback<NewsFeedViewData>() {
        override fun areItemsTheSame(
            oldItem: NewsFeedViewData,
            newItem: NewsFeedViewData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: NewsFeedViewData,
            newItem: NewsFeedViewData
        ): Boolean {
            return false
        }
    }
}

internal fun NewsFeeds.mapToViewData() = NewsFeedViewData(
    id, type, stories.mapToViewData(), post.mapToViewData(), friendRequests.mapToViewData()
)

internal fun List<NewsFeeds>.mapToViewData() = this.map { it.mapToViewData() }