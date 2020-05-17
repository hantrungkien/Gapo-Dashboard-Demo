package com.kienht.gapo.post_details.adapter

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.core.utils.inflateViewDataBinding
import com.kienht.gapo.post_details.R
import com.kienht.gapo.post_details.adapter.viewholder.CommentBaseViewHolder
import com.kienht.gapo.post_details.adapter.viewholder.CommentViewHolder
import com.kienht.gapo.post_details.adapter.viewholder.CommentWithRepliesViewHolder
import com.kienht.gapo.post_details.model.CommentViewData

/**
 * @author kienht
 * @company OICSoft
 * @since 17/05/2020
 */
class CommentAdapter(
    private val lifecycleOwner: LifecycleOwner
) : ListAdapter<CommentViewData, RecyclerView.ViewHolder>(
    CommentViewData.DiffItemCallback
) {

    init {
        setHasStableIds(true)
        stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = parent.inflateViewDataBinding(viewType)
        return when (viewType) {
            R.layout.post_comment_item -> CommentViewHolder(binding, lifecycleOwner)
            R.layout.post_comment_with_replies_item ->
                CommentWithRepliesViewHolder(binding, lifecycleOwner)
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is CommentViewHolder -> holder.bind(item)
            is CommentWithRepliesViewHolder -> holder.bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.replies == null) R.layout.post_comment_item else R.layout.post_comment_with_replies_item
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        (holder as? CommentBaseViewHolder<*>)?.onViewRecycled()
    }

}