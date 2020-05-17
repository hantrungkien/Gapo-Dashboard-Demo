package com.kienht.gapo.dashboard.news_feed.adapter.viewholder.story

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.dashboard.databinding.NewsFeedStoriesItemBinding
import com.kienht.gapo.dashboard.news_feed.adapter.viewholder.NewsFeedBaseViewHolder
import com.kienht.gapo.dashboard.news_feed.decoration.StoriesDecoration
import com.kienht.gapo.dashboard.news_feed.model.StoryViewData

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
        if (binding is NewsFeedStoriesItemBinding) {
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
