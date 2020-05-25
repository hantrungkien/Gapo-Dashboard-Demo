package com.kienht.gapo.dashboard.news_feeds.adapter.viewholder.friend_request

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import com.kienht.gapo.core.utils.glideClear
import com.kienht.gapo.core.utils.inflateViewDataBinding
import com.kienht.gapo.dashboard.R
import com.kienht.gapo.dashboard.databinding.NewsFeedsFriendRequestItemBinding
import com.kienht.gapo.dashboard.news_feeds.adapter.viewholder.NewsFeedBaseViewHolder
import com.kienht.gapo.dashboard.news_feeds.model.FriendRequestViewData

/**
 * @author kienht
 */
class FriendRequestAdapter(private val viewLifecycleOwner: LifecycleOwner) :
    ListAdapter<FriendRequestViewData, FriendRequestAdapter.FriendRequestViewHolder>(
        FriendRequestViewData.DiffItemCallback
    ) {

    init {
        setHasStableIds(true)
        stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FriendRequestViewHolder {
        return FriendRequestViewHolder(parent.inflateViewDataBinding(viewType), viewLifecycleOwner)
    }

    override fun onBindViewHolder(
        holder: FriendRequestViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position), null)
    }

    override fun getItemViewType(position: Int): Int = R.layout.news_feeds_friend_request_item

    override fun onViewRecycled(holder: FriendRequestViewHolder) {
        super.onViewRecycled(holder)
        holder.onViewRecycled()
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id
    }

    inner class FriendRequestViewHolder(
        private val binding: NewsFeedsFriendRequestItemBinding,
        viewLifecycleOwner: LifecycleOwner
    ) :
        NewsFeedBaseViewHolder<FriendRequestViewData>(binding, viewLifecycleOwner) {

        override fun onViewRecycled() {
            super.onViewRecycled()
            binding.imageFriendAvatar.glideClear()
        }
    }
}
