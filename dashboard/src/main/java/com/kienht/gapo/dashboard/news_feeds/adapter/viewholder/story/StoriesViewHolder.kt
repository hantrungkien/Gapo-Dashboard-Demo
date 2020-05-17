package com.kienht.gapo.dashboard.news_feeds.adapter.viewholder.story

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.dashboard.databinding.NewsFeedsStoriesItemBinding
import com.kienht.gapo.dashboard.news_feeds.adapter.viewholder.NewsFeedBaseViewHolder
import com.kienht.gapo.dashboard.news_feeds.decoration.StoriesDecoration
import com.kienht.gapo.dashboard.news_feeds.model.StoryViewData

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
class StoriesViewHolder(
    binding: ViewDataBinding,
    pool: RecyclerView.RecycledViewPool,
    lifecycleOwner: LifecycleOwner
) : NewsFeedBaseViewHolder<List<StoryViewData>>(binding, lifecycleOwner) {

    init {
        if (binding is NewsFeedsStoriesItemBinding) {
            val context = binding.root.context
            binding.listStories.apply {
                itemAnimator = null
                setRecycledViewPool(pool)
                addItemDecoration(StoriesDecoration(context))
                isNestedScrollingEnabled = false
                layoutManager =
                    LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                adapter = StoryAdapter(lifecycleOwner)
            }
        }
    }

}
