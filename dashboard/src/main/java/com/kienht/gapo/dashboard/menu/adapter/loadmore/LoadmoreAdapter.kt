package com.kienht.gapo.dashboard.menu.adapter.loadmore

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.core.utils.inflateViewDataBinding
import com.kienht.gapo.dashboard.R
import com.kienht.gapo.dashboard.databinding.LoadmoreItemBinding
import com.kienht.gapo.dashboard.news_feeds.adapter.viewholder.NewsFeedBaseViewHolder

/**
 * @author vit
 */
class LoadmoreAdapter(private val viewLifecycleOwner: LifecycleOwner) :
    RecyclerView.Adapter<LoadmoreAdapter.LoadmoreViewHolder>() {

    var loading = false
        set(value) {
            when(field) {
                value -> notifyItemChanged(0)
                true -> {
                    itemsCount = 0
                    notifyItemRemoved(0)
                }
                false -> {
                    itemsCount = 1
                    notifyItemInserted(1)
                }
            }
            field = value
        }
    private var itemsCount: Int = 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LoadmoreAdapter.LoadmoreViewHolder {
        return LoadmoreViewHolder(
            parent.inflateViewDataBinding(viewType),
            viewLifecycleOwner
        )
    }

    override fun onBindViewHolder(
        holder: LoadmoreViewHolder,
        position: Int
    ) {
        holder.bind(loading, null)
    }

    override fun getItemViewType(position: Int): Int = R.layout.loadmore_item

    override fun getItemCount(): Int = itemsCount

    inner class LoadmoreViewHolder(
        private val binding: LoadmoreItemBinding,
        viewLifecycleOwner: LifecycleOwner
    ) : NewsFeedBaseViewHolder<Boolean>(binding, viewLifecycleOwner) {

    }

}