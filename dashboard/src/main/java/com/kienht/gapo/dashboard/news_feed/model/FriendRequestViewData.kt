package com.kienht.gapo.dashboard.news_feed.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
@Parcelize
data class FriendRequestViewData(
    val id: Long,
    val friendName: String,
    val friendAvatar: String,
    val mutualFriendsCount: Int
) : Parcelable {

    object DiffItemCallback : DiffUtil.ItemCallback<FriendRequestViewData>() {
        override fun areItemsTheSame(
            oldItem: FriendRequestViewData,
            newItem: FriendRequestViewData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: FriendRequestViewData,
            newItem: FriendRequestViewData
        ): Boolean {
            return oldItem.mutualFriendsCount == newItem.mutualFriendsCount
        }
    }
}