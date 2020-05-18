package com.kienht.gapo.dashboard.news_feeds.model

import android.os.Parcelable
import com.kienht.gapo.dashboard.domain.usecase.news.model.Post
import kotlinx.android.parcel.Parcelize

/**
 * @author kienht
 */
@Parcelize
data class PostViewData(
    val id: Long,
    val type: Post.Type,
    val username: String,
    val userAvatar: String,
    val time: String,
    val content: String,
    val images: List<String>?,
    val video: String?,
    val likeCount: String,
    val commentCount: String,
    val shareCount: String
) : Parcelable {

    val firstImage: String
        get() = images?.first() ?: ""
}

internal fun Post?.mapToViewData() = if (this == null) null else PostViewData(
    id,
    type,
    username,
    userAvatar,
    time,
    content,
    images,
    video,
    likeCount,
    commentCount,
    shareCount
)