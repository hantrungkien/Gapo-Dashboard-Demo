package com.kienht.gapo.post_details.adapter.viewholder

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.post_details.BR

/**
 * @author kienht
 */
abstract class CommentBaseViewHolder<T>(
    private val binding: ViewDataBinding,
    lifecycleOwner: LifecycleOwner
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.lifecycleOwner = lifecycleOwner
    }

    open fun bind(item: T) {
        binding.apply {
            setVariable(BR.item, item)
            setVariable(BR.adapterPosition, bindingAdapterPosition)
            executePendingBindings()
        }
    }

    open fun onViewRecycled() {
        binding.unbind()
    }

    open fun onViewAttachedToWindow() {
    }

    open fun onViewDetachedFromWindow() {
    }
}
