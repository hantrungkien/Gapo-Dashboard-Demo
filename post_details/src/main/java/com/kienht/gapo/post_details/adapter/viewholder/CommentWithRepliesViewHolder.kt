package com.kienht.gapo.post_details.adapter.viewholder

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.kienht.gapo.core.utils.glideClear
import com.kienht.gapo.post_details.adapter.CommentAdapter
import com.kienht.gapo.post_details.databinding.PostCommentWithRepliesItemBinding
import com.kienht.gapo.post_details.decoration.CommentDecoration
import com.kienht.gapo.post_details.model.CommentViewData

/**
 * @author kienht
 * @company OICSoft
 * @since 17/05/2020
 */
class CommentWithRepliesViewHolder(
    private val binding: ViewDataBinding,
    private val lifecycleOwner: LifecycleOwner
) : CommentBaseViewHolder<CommentViewData>(binding, lifecycleOwner) {

    init {
        if (binding is PostCommentWithRepliesItemBinding) {
            binding.listReplies.apply {
                itemAnimator = null
                layoutManager = LinearLayoutManager(this.context)
                addItemDecoration(CommentDecoration(this.context))
                isNestedScrollingEnabled = false
                adapter = CommentAdapter(lifecycleOwner)
            }
        }
    }

    override fun onViewRecycled() {
        super.onViewRecycled()
        if (binding is PostCommentWithRepliesItemBinding) {
            binding.layoutContent.imageAvatar.glideClear()
        }
    }
}