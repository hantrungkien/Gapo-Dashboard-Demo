package com.kienht.gapo.dashboard.news_feeds.adapter.viewholder

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.dashboard.BR
import com.kienht.gapo.dashboard.news_feeds.adapter.OnClickPostItemListener

/**
 * @author kienht
 */
abstract class NewsFeedBaseViewHolder<T>(
    private val binding: ViewDataBinding,
    lifecycleOwner: LifecycleOwner
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.lifecycleOwner = lifecycleOwner
    }

    open fun bind(
        item: T,
        clickItemListener: OnClickPostItemListener?
    ) {
        binding.apply {
            setVariable(BR.item, item)
            setVariable(BR.clickItem, clickItemListener)
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