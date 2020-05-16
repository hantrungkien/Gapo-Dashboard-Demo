package com.kienht.gapo.dashboard.news_feed.adapter.viewholder.story

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.dashboard.news_feed.adapter.viewholder.NewsFeedBaseViewHolder
import com.kienht.gapo.dashboard.news_feed.model.StoryViewData

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
class StoryViewHolder(
    binding: ViewDataBinding,
    pool: RecyclerView.RecycledViewPool,
    lifecycleOwner: LifecycleOwner
) : NewsFeedBaseViewHolder<List<StoryViewData>>(binding, lifecycleOwner) {

}
