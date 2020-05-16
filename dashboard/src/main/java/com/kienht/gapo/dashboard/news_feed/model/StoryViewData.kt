package com.kienht.gapo.dashboard.news_feed.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.kienht.gapo.dashboard.domain.usecase.news.model.Story
import kotlinx.android.parcel.Parcelize

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
@Parcelize
data class StoryViewData(
    val id: Long,
    val username: String,
    val userAvatar: String,
    val contentUrl: String
) : Parcelable {

    object DiffItemCallback : DiffUtil.ItemCallback<StoryViewData>() {
        override fun areItemsTheSame(
            oldItem: StoryViewData,
            newItem: StoryViewData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: StoryViewData,
            newItem: StoryViewData
        ): Boolean {
            return oldItem.contentUrl == newItem.contentUrl
        }
    }
}

internal fun Story.mapToViewData() = StoryViewData(id, username, userAvatar, contentUrl)
internal fun List<Story>?.mapToViewData() = this?.map { it.mapToViewData() }