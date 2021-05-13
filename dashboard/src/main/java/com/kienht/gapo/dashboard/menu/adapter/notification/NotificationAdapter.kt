package com.kienht.gapo.dashboard.menu.adapter.notification

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import com.kienht.gapo.core.utils.glideClear
import com.kienht.gapo.core.utils.inflateViewDataBinding
import com.kienht.gapo.dashboard.R
import com.kienht.gapo.dashboard.databinding.NotificationItemBinding
import com.kienht.gapo.dashboard.news_feeds.adapter.viewholder.NewsFeedBaseViewHolder
import com.kienht.gapo.dashboard.news_feeds.model.StoryViewData

/**
 * @author kienht
 */
class NotificationAdapter(private val viewLifecycleOwner: LifecycleOwner) :
    ListAdapter<StoryViewData, NotificationAdapter.NotificationViewHolder>(
        StoryViewData.DiffItemCallback
    ) {

    init {
        setHasStableIds(true)
        stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotificationViewHolder {
        return NotificationViewHolder(parent.inflateViewDataBinding(viewType), viewLifecycleOwner)
    }

    override fun onBindViewHolder(
        holder: NotificationViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position), null)
    }

    override fun getItemViewType(position: Int): Int = R.layout.notification_item

    override fun onViewRecycled(holder: NotificationViewHolder) {
        super.onViewRecycled(holder)
        holder.onViewRecycled()
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id
    }

    inner class NotificationViewHolder(
        private val binding: NotificationItemBinding,
        viewLifecycleOwner: LifecycleOwner
    ) :
        NewsFeedBaseViewHolder<StoryViewData>(binding, viewLifecycleOwner) {

        override fun onViewRecycled() {
            super.onViewRecycled()
            binding.imageAvatar.glideClear()
        }
    }
}