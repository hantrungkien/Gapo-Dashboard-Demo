package com.kienht.gapo.dashboard.news_feed.adapter.viewholder.post_text

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.kienht.gapo.core.utils.glideClear
import com.kienht.gapo.dashboard.databinding.NewsFeedPostTextItemBinding
import com.kienht.gapo.dashboard.news_feed.adapter.viewholder.NewsFeedBaseViewHolder
import com.kienht.gapo.dashboard.news_feed.model.PostViewData

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
class PostTextViewHolder(
    private val binding: ViewDataBinding,
    lifecycleOwner: LifecycleOwner
) : NewsFeedBaseViewHolder<PostViewData>(binding, lifecycleOwner) {

    override fun onViewRecycled() {
        super.onViewRecycled()
        if (binding is NewsFeedPostTextItemBinding) {
            binding.imageAvatar.glideClear()
        }
    }
}
