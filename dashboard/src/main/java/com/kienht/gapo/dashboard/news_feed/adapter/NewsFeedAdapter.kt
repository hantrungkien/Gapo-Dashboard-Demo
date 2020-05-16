package com.kienht.gapo.dashboard.news_feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kienht.gapo.dashboard.R
import com.kienht.gapo.dashboard.news_feed.adapter.viewholder.post_text.PostTextViewHolder
import com.kienht.gapo.dashboard.news_feed.adapter.viewholder.NewsFeedBaseViewHolder
import com.kienht.gapo.dashboard.news_feed.adapter.viewholder.post_image.PostImageViewHolder
import com.kienht.gapo.dashboard.news_feed.adapter.viewholder.post_video.PostVideoViewHolder
import com.kienht.gapo.dashboard.news_feed.adapter.viewholder.story.StoryViewHolder
import com.kienht.gapo.dashboard.news_feed.adapter.viewholder.suggestion.SuggestionViewHolder
import com.kienht.gapo.dashboard.news_feed.model.NewsFeedViewData
import com.kienht.gapo.dashboard.news_feed.model.PostViewData

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */

interface OnClickPostItemListener {

    fun onClickPost(post: NewsFeedViewData, position: Int)
}

class NewsFeedAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val pool: RecyclerView.RecycledViewPool,
    private val onClickPostItemListener: OnClickPostItemListener
) : ListAdapter<NewsFeedViewData, RecyclerView.ViewHolder>(
    NewsFeedViewData.DiffItemCallback
) {

    init {
        setHasStableIds(true)
        stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        val layoutManager = recyclerView.layoutManager
        (layoutManager as? LinearLayoutManager)?.recycleChildrenOnDetach = true
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = getViewDataBinding(parent, viewType)
        return when (viewType) {
            R.layout.news_feed_stories_item -> {
                StoryViewHolder(
                    binding,
                    pool,
                    lifecycleOwner
                )
            }
            R.layout.news_feed_post_text_item -> {
                PostTextViewHolder(
                    binding,
                    lifecycleOwner
                )
            }
            R.layout.news_feed_post_image_item -> {
                PostImageViewHolder(
                    binding,
                    lifecycleOwner
                )
            }
            R.layout.news_feed_post_video_item -> {
                PostVideoViewHolder(
                    binding,
                    lifecycleOwner
                )
            }
            R.layout.news_feed_suggestions_item -> {
                SuggestionViewHolder(
                    binding,
                    pool,
                    lifecycleOwner
                )
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val newsfeed = getItem(position)
        when (holder) {
            is PostTextViewHolder -> {
                newsfeed.post?.let { holder.bind(it, onClickPostItemListener) }
            }
            is PostImageViewHolder -> {
                newsfeed.post?.let { holder.bind(it, onClickPostItemListener) }
            }
            is PostVideoViewHolder -> {
                newsfeed.post?.let { holder.bind(it, onClickPostItemListener) }
            }
            is SuggestionViewHolder -> {
                newsfeed.suggestions?.let { holder.bind(it, onClickPostItemListener) }
            }
            is StoryViewHolder -> {
                newsfeed.stories?.let { holder.bind(it, onClickPostItemListener) }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when (item.type) {
            NewsFeedViewData.Type.STORY -> R.layout.news_feed_stories_item
            NewsFeedViewData.Type.POST -> when (item.post?.type) {
                PostViewData.Type.TEXT -> {
                    R.layout.news_feed_post_text_item
                }
                PostViewData.Type.IMAGE -> {
                    R.layout.news_feed_post_image_item
                }
                PostViewData.Type.VIDEO -> {
                    R.layout.news_feed_post_video_item
                }
                else -> throw IllegalArgumentException()
            }
            NewsFeedViewData.Type.SUGGESTION -> R.layout.news_feed_suggestions_item
        }
    }

    override fun getItemId(position: Int): Long {
        return currentList[position].id
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        val layoutManager = recyclerView.layoutManager as? LinearLayoutManager
        if (layoutManager != null) {
            val first = layoutManager.findFirstVisibleItemPosition()
            val last = layoutManager.findLastVisibleItemPosition()
            for (i in first..last) {
                val holder = recyclerView.findViewHolderForAdapterPosition(i)
                (holder as? NewsFeedBaseViewHolder<*>)?.onViewRecycled()
            }
        }
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        (holder as? NewsFeedBaseViewHolder<*>)?.onViewAttachedToWindow()
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        (holder as? NewsFeedBaseViewHolder<*>)?.onViewDetachedFromWindow()
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        (holder as? NewsFeedBaseViewHolder<*>)?.onViewRecycled()
    }

    private fun getViewDataBinding(parent: ViewGroup, layout: Int): ViewDataBinding =
        DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layout,
            parent,
            false
        )
}