package com.kienht.gapo.dashboard.news_feed.adapter.viewholder.friend_request

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.core.base.GlideApp
import com.kienht.gapo.dashboard.databinding.NewsFeedFriendRequestsItemBinding
import com.kienht.gapo.dashboard.news_feed.adapter.viewholder.NewsFeedBaseViewHolder
import com.kienht.gapo.dashboard.news_feed.decoration.FriendRequestDecoration
import com.kienht.gapo.dashboard.news_feed.model.FriendRequestViewData

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
class FriendRequestViewHolder(
    binding: ViewDataBinding,
    pool: RecyclerView.RecycledViewPool,
    lifecycleOwner: LifecycleOwner
) : NewsFeedBaseViewHolder<List<FriendRequestViewData>>(binding, lifecycleOwner) {

    init {
        if (binding is NewsFeedFriendRequestsItemBinding) {
            val context = binding.root.context
            binding.listFriendRequest.apply {
                itemAnimator = null
                setHasFixedSize(true)//only for demo
                setRecycledViewPool(pool)
                addItemDecoration(FriendRequestDecoration(context))
                layoutManager =
                    LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                adapter = FriendRequestAdapter(lifecycleOwner)
            }
        }
    }
}
