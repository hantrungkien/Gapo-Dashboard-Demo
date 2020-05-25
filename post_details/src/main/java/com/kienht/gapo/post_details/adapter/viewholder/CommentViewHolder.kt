package com.kienht.gapo.post_details.adapter.viewholder

import androidx.lifecycle.LifecycleOwner
import com.kienht.gapo.core.utils.glideClear
import com.kienht.gapo.post_details.databinding.PostCommentItemBinding
import com.kienht.gapo.post_details.model.CommentViewData

/**
 * @author kienht
 */
class CommentViewHolder(
    private val binding: PostCommentItemBinding,
    lifecycleOwner: LifecycleOwner
) : CommentBaseViewHolder<CommentViewData>(binding, lifecycleOwner) {
    override fun onViewRecycled() {
        super.onViewRecycled()
        binding.imageAvatar.glideClear()
    }
}
