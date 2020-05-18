@file:JvmName("UtilsExtension")

package com.kienht.gapo.core.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.kienht.gapo.core.base.GlideApp
import kotlin.collections.ArrayList

/**
 * @author kienht
 */

inline val <reified T : Any> T.TAG: String
    get() {
        val tag = T::class.java.simpleName
        return if (tag.length <= 23) tag else tag.substring(0, 23)
    }

fun <T> Collection<T>.toArrayList(): ArrayList<T> {
    return ArrayList(this)
}

fun ImageView.glideClear() {
    if ((context as? AppCompatActivity)?.isDestroyed == true) return
    GlideApp.with(this).clear(this)
    setImageDrawable(null)
}

inline fun <reified T : ViewDataBinding> FragmentActivity.setContentViewDataBinding(@LayoutRes layout: Int): T =
    DataBindingUtil.setContentView<T>(this, layout)
        .apply {
            lifecycleOwner = this@setContentViewDataBinding
        }

inline fun <reified T : ViewDataBinding> Fragment.inflateViewDataBinding(
    viewGroup: ViewGroup,
    @LayoutRes layout: Int
): T = viewGroup.inflateViewDataBinding<T>(layout)
    .apply {
        lifecycleOwner = this@inflateViewDataBinding.viewLifecycleOwner
    }

inline fun <reified T : ViewDataBinding> ViewGroup.inflateViewDataBinding(@LayoutRes layout: Int): T =
    DataBindingUtil.inflate<T>(
        LayoutInflater.from(context),
        layout,
        this,
        false
    )