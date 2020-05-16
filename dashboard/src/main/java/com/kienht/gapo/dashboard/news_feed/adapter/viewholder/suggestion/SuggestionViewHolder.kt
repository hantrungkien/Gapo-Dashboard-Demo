package com.kienht.gapo.dashboard.news_feed.adapter.viewholder.suggestion

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.dashboard.news_feed.adapter.viewholder.NewsFeedBaseViewHolder
import com.kienht.gapo.dashboard.news_feed.model.SuggestionViewData

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
class SuggestionViewHolder(
    binding: ViewDataBinding,
    pool: RecyclerView.RecycledViewPool,
    lifecycleOwner: LifecycleOwner
) : NewsFeedBaseViewHolder<List<SuggestionViewData>>(binding, lifecycleOwner) {

}
