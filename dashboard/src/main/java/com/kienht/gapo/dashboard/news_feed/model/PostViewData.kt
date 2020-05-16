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
    val content: String,
    val image: String
) : Parcelable {

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