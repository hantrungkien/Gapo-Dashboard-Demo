package com.kienht.gapo.post_details.adapter.viewholder

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.kienht.gapo.core.utils.glideClear
import com.kienht.gapo.post_details.databinding.PostCommentItemBinding
import com.kienht.gapo.post_details.model.CommentViewData

/**
 * @author kienht
 * @company OICSoft
 * @since 17/05/2020
 */
class CommentViewHolder(
    private val binding: ViewDataBinding,
    lifecycleOwner: LifecycleOwner
) : CommentBaseViewHolder<CommentViewData>(binding, lifecycleOwner) {
    override fun onViewRecycled() {
        super.onViewRecycled()
        if (binding is PostCommentItemBinding) {
            binding.imageAvatar.glideClear()
        }
    }
}