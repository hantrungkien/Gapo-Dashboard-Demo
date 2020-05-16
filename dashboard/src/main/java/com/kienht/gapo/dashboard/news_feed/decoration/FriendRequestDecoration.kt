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
class FriendRequestDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val _10dp = context.resources.getDimensionPixelSize(autoDimens._10dp)
    private val _15dp = context.resources.getDimensionPixelSize(autoDimens._15dp)

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
            outRect.left = _15dp
        }
        if (itemPosition == (parent.adapter?.itemCount ?: 0) - 1) {
            outRect.right = _15dp
        } else {
            outRect.right = _10dp
        }
        outRect.top = _10dp
        outRect.bottom = _10dp
    }
}