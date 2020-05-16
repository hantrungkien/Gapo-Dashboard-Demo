package com.kienht.gapo.dashboard.news_feed.adapter.viewholder

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.dashboard.BR
import com.kienht.gapo.dashboard.news_feed.adapter.OnClickPostItemListener

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
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