package com.kienht.gapo.dashboard.news_feeds.adapter.viewholder.post_text

import androidx.lifecycle.LifecycleOwner
import com.kienht.gapo.core.utils.glideClear
import com.kienht.gapo.dashboard.databinding.NewsFeedsPostTextItemBinding
import com.kienht.gapo.dashboard.news_feeds.adapter.viewholder.NewsFeedBaseViewHolder
import com.kienht.gapo.dashboard.news_feeds.model.PostViewData

/**
 * @author kienht
 */
class PostTextViewHolder(
    private val binding: NewsFeedsPostTextItemBinding,
    lifecycleOwner: LifecycleOwner
) : NewsFeedBaseViewHolder<PostViewData>(binding, lifecycleOwner) {

    override fun onViewRecycled() {
        super.onViewRecycled()
        binding.imageAvatar.glideClear()
    }
}
