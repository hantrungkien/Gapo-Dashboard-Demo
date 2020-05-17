package com.kienht.gapo.dashboard.news_feeds.decoration

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
class StoriesDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val space = context.resources.getDimensionPixelSize(autoDimens._10dp)

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
            outRect.left = space
        }
        outRect.right = space
        outRect.top = space
        outRect.bottom = space
    }
}