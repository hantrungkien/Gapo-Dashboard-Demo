package com.kienht.gapo.post_details.adapter.viewholder

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.kienht.gapo.core.utils.glideClear
import com.kienht.gapo.post_details.adapter.CommentAdapter
import com.kienht.gapo.post_details.databinding.PostCommentWithRepliesItemBinding
import com.kienht.gapo.post_details.decoration.CommentDecoration
import com.kienht.gapo.post_details.model.CommentViewData

/**
 * @author kienht
 */
class CommentWithRepliesViewHolder(
    private val binding: PostCommentWithRepliesItemBinding,
    private val lifecycleOwner: LifecycleOwner
) : CommentBaseViewHolder<CommentViewData>(binding, lifecycleOwner) {

    init {
        binding.listReplies.apply {
            itemAnimator = null
            layoutManager = LinearLayoutManager(this.context)
            addItemDecoration(CommentDecoration(this.context))
            isNestedScrollingEnabled = false
            adapter = CommentAdapter(lifecycleOwner)
        }
    }

    override fun onViewRecycled() {
        super.onViewRecycled()
        binding.layoutContent.imageAvatar.glideClear()
    }
}