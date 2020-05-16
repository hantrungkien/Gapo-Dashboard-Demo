package com.kienht.gapo.dashboard.news_feed.adapter.viewholder.post_video

import android.graphics.Point
import android.graphics.Rect
import android.view.ViewParent
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.brightcove.player.event.EventType
import com.brightcove.player.model.DeliveryType
import com.brightcove.player.model.Video
import com.brightcove.player.view.BaseVideoView
import com.brightcove.player.view.BrightcoveExoPlayerTextureVideoView
import com.kienht.gapo.core.utils.glideClear
import com.kienht.gapo.dashboard.databinding.NewsFeedPostVideoItemBinding
import com.kienht.gapo.dashboard.news_feed.adapter.OnClickPostItemListener
import com.kienht.gapo.dashboard.news_feed.adapter.viewholder.NewsFeedBaseViewHolder
import com.kienht.gapo.dashboard.news_feed.model.PostViewData

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
class PostVideoViewHolder(
    private val binding: ViewDataBinding,
    lifecycleOwner: LifecycleOwner
) : NewsFeedBaseViewHolder<PostViewData>(binding, lifecycleOwner) {

    private var exoPlayer: BrightcoveExoPlayerTextureVideoView? = null

    init {
        if (binding is NewsFeedPostVideoItemBinding && exoPlayer == null) {
            val context = binding.root.context
            exoPlayer = BrightcoveExoPlayerTextureVideoView(context)
            binding.layoutVideo.addView(exoPlayer)
            exoPlayer?.finishInitialization()
            exoPlayer?.eventEmitter?.on(EventType.ANY) {
                if (exoPlayer?.isPlaying == true && exoPlayer?.shouldPause(binding.layoutVideo) == true) {
                    exoPlayer?.pause()
                }
                when (it.type) {
                    EventType.SET_VIDEO_STILL -> {
                        it.preventDefault()
                        it.stopPropagation()
                    }
                }
            }
        }
    }

    override fun bind(item: PostViewData, clickItemListener: OnClickPostItemListener?) {
        super.bind(item, clickItemListener)
        exoPlayer?.clear()
        exoPlayer?.add(
            Video.createVideo(
                item.video ?: "",
                DeliveryType.MP4
            )
        )
    }

    override fun onViewAttachedToWindow() {
        super.onViewAttachedToWindow()
        exoPlayer?.start()
    }

    override fun onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow()
        exoPlayer?.stopPlayback()
    }

    override fun onViewRecycled() {
        super.onViewRecycled()
        exoPlayer?.stopPlayback()
        if (binding is NewsFeedPostVideoItemBinding) {
            binding.imageAvatar.glideClear()
        }
    }

    private fun BaseVideoView.shouldPause(parent: ViewParent?): Boolean =
        if (parent == null) false else this.getVisibleAreaOffset(parent) < 0.85f

    private fun BaseVideoView.getVisibleAreaOffset(container: ViewParent?): Float {
        if (container == null) return 0.0f

        val drawRect = Rect()
        getDrawingRect(drawRect)
        val drawArea = drawRect.width() * drawRect.height()

        val playerRect = Rect()
        val visible = getGlobalVisibleRect(playerRect, Point())

        var offset = 0f
        if (visible && drawArea > 0) {
            val visibleArea = playerRect.height() * playerRect.width()
            offset = visibleArea / drawArea.toFloat()
        }
        return offset
    }

}
