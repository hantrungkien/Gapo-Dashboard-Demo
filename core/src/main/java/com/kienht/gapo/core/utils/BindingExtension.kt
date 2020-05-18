@file:JvmName("BindingExtension")

package com.kienht.gapo.core.utils

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.*
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.kienht.gapo.core.base.GlideApp

/**
 * @author kienht
 */
@set:BindingAdapter("isVisible")
inline var View.isVisible: Boolean?
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value == true) View.VISIBLE else View.GONE
    }

@set:BindingAdapter("isInvisible")
inline var View.isInvisible: Boolean?
    get() = visibility == View.INVISIBLE
    set(value) {
        visibility = if (value == true) View.INVISIBLE else View.VISIBLE
    }

@BindingAdapter("submitList")
fun <T> RecyclerView.setDataBinding(data: List<T>?) {
    @Suppress("UNCHECKED_CAST")
    (adapter as? ListAdapter<T, *>)?.submitList(data)
}

@SuppressLint("CheckResult")
@BindingAdapter(
    value = ["url", "placeHolder", "error", "scaleType", "isCircle"],
    requireAll = false
)
fun ImageView.setImageBinding(
    url: String?,
    placeHolder: Drawable?,
    error: Drawable?,
    scaleType: ImageView.ScaleType? = null,
    isCircle: Boolean = false
) {
    val requestOptions = RequestOptions()

    if (placeHolder != null) {
        requestOptions.placeholder(placeHolder)
    }
    if (error != null) {
        requestOptions.error(error)
    }

    if (isCircle) {
        requestOptions.circleCrop()
    }

    if (!isCircle && scaleType != null) {
        when (scaleType) {
            ImageView.ScaleType.MATRIX -> {
                setScaleType(ImageView.ScaleType.MATRIX)
            }
            ImageView.ScaleType.FIT_XY -> {
                setScaleType(ImageView.ScaleType.FIT_XY)
            }
            ImageView.ScaleType.FIT_START -> {
                setScaleType(ImageView.ScaleType.FIT_START)
            }
            ImageView.ScaleType.FIT_CENTER -> {
                requestOptions.fitCenter()
                if (url.isNullOrEmpty()) {
                    setScaleType(ImageView.ScaleType.FIT_CENTER)
                }
            }
            ImageView.ScaleType.FIT_END -> {
                setScaleType(ImageView.ScaleType.FIT_END)
            }
            ImageView.ScaleType.CENTER -> {
                setScaleType(ImageView.ScaleType.CENTER)
            }
            ImageView.ScaleType.CENTER_CROP -> {
                requestOptions.centerCrop()
                if (url.isNullOrEmpty()) {
                    setScaleType(ImageView.ScaleType.CENTER_CROP)
                }
            }
            ImageView.ScaleType.CENTER_INSIDE -> {
                requestOptions.centerInside()
                if (url.isNullOrEmpty()) {
                    setScaleType(ImageView.ScaleType.CENTER_INSIDE)
                }
            }
        }
    }
    GlideApp.with(this)
        .load(url)
        .transition(withCrossFade())
        .dontAnimate()
        .apply(requestOptions)
        .priority(Priority.IMMEDIATE)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}
