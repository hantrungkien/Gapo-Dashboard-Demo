@file:JvmName("UtilsExtension")

package com.kienht.gapo.core.utils

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