package com.kienht.gapo.dashboard.news_feeds.adapter.viewholder.story

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import com.kienht.gapo.core.utils.glideClear
import com.kienht.gapo.core.utils.inflateViewDataBinding
import com.kienht.gapo.dashboard.R
import com.kienht.gapo.dashboard.databinding.NewsFeedsStoryItemBinding
import com.kienht.gapo.dashboard.news_feeds.adapter.viewholder.NewsFeedBaseViewHolder
import com.kienht.gapo.dashboard.news_feeds.model.StoryViewData

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
class StoryAdapter(private val viewLifecycleOwner: LifecycleOwner) :
    ListAdapter<StoryViewData, StoryAdapter.StoryViewHolder>(
        StoryViewData.DiffItemCallback
    ) {

    init {
        setHasStableIds(true)
        stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StoryViewHolder {
        val binding = parent.inflateViewDataBinding(viewType)
        return StoryViewHolder(binding, viewLifecycleOwner)
    }

    override fun onBindViewHolder(
        holder: StoryViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position), null)
    }

    override fun getItemViewType(position: Int): Int = R.layout.news_feeds_story_item

    override fun onViewRecycled(holder: StoryViewHolder) {
        super.onViewRecycled(holder)
        holder.onViewRecycled()
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id
    }

    inner class StoryViewHolder(
        private val binding: ViewDataBinding,
        viewLifecycleOwner: LifecycleOwner
    ) :
        NewsFeedBaseViewHolder<StoryViewData>(binding, viewLifecycleOwner) {

        override fun onViewRecycled() {
            super.onViewRecycled()
            if (binding is NewsFeedsStoryItemBinding) {
                binding.imageAvatar.glideClear()
                binding.imageContent.glideClear()
            }
        }
    }
}