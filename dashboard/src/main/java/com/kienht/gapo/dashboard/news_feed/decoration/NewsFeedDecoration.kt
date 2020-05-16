package com.kienht.gapo.dashboard.news_feed.decoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import htkien.autodimens.R.dimen as autoDimens

/**
 * @author kienht
 * @company OICSoft
 * @since 16/10/2019
 */
class NewsFeedDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val space = context.resources.getDimensionPixelSize(autoDimens._5dp)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val itemPosition = parent.getChildAdapterPosition(view)
        if (itemPosition == RecyclerView.NO_POSITION) {
            return
        }

        if (itemPosition == 0) {
            outRect.top = space
        } else {
            outRect.bottom = space
        }
    }
}