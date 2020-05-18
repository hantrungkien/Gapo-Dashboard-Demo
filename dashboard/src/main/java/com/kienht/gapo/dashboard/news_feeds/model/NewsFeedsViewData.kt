package com.kienht.gapo.dashboard.news_feeds.model

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import com.kienht.gapo.dashboard.domain.usecase.news.model.NewsFeeds
import kotlinx.android.parcel.Parcelize

/**
 * @author kienht
 */
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

        /**
         * Cần triển khai chi tiết cho trường hợp dữ liệu được CRUD.
         */
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