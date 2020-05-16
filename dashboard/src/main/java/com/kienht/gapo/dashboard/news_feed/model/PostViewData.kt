package com.kienht.gapo.dashboard.news_feed.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
@Parcelize
data class PostViewData(
    val id: Long,
    val type: Type,
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

    enum class Type {

        TEXT {
            override fun value(): String = "TEXT"
        },
        IMAGE {
            override fun value(): String = "IMAGE"
        },
        VIDEO {
            override fun value(): String = "VIDEO"
        };

        abstract fun value(): String
    }
}