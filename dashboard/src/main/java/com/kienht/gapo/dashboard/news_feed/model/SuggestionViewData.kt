package com.kienht.gapo.dashboard.news_feed.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
@Parcelize
data class SuggestionViewData(
    val id: Long,
    val name: String,
    val avatar: String
) : Parcelable