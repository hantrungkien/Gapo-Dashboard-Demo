package com.kienht.gapo.core.common

/**
 * @author kienht
 */
sealed class DataState<out R> {
    object LOADING : DataState<Nothing>()
    object RETRYING : DataState<Nothing>()
    object COMPLETE : DataState<Nothing>()
    class ERROR(val throwable: Throwable?) : DataState<Nothing>()
    class SUCCESS<T>(val data: T) : DataState<T>()

    override fun toString(): String {
        return when (this) {
            is LOADING -> "DataState is LOADING..."
            is RETRYING -> "DataState is RETRYING..."
            is COMPLETE -> "DataState is COMPLETE..."
            is SUCCESS<*> -> "DataState is SUCCESS: [data=$data]"
            is ERROR -> "DataState is ERROR: [exception=$throwable]"
        }
    }
}