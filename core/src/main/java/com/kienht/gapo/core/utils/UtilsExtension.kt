@file:JvmName("UtilsExtension")

package com.kienht.gapo.core.utils

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.kienht.gapo.core.base.GlideApp
import kotlin.collections.ArrayList

/**
 * @author kienht
 * @company OICSoft
 * @since 12/12/2018
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