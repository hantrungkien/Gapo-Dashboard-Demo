package com.kienht.gapo.dashboard.news_feed.adapter.viewholder.post_image

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.kienht.gapo.core.utils.glideClear
import com.kienht.gapo.dashboard.databinding.NewsFeedPostImageItemBinding
import com.kienht.gapo.dashboard.news_feed.adapter.viewholder.NewsFeedBaseViewHolder
import com.kienht.gapo.dashboard.news_feed.model.PostViewData

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
class PostImageViewHolder(
    private val binding: ViewDataBinding,
    lifecycleOwner: LifecycleOwner
) : NewsFeedBaseViewHolder<PostViewData>(binding, lifecycleOwner) {

    override fun onViewRecycled() {
        super.onViewRecycled()
        if (binding is NewsFeedPostImageItemBinding) {
            binding.imageAvatar.glideClear()
            binding.imageContent.glideClear()
        }
    }
}
