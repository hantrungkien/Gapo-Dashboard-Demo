package com.kienht.gapo.post_details.model

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

/**
 * @author kienht
 */
class CommentsLiveData(list: List<CommentViewData>) : MutableLiveData<List<CommentViewData>>(list) {
    override fun setValue(value: List<CommentViewData>) {
        super.setValue(value.copy())
    }

    override fun postValue(value: List<CommentViewData>) {
        super.postValue(value.copy())
    }

    private fun List<CommentViewData>.copy() = this.map { it.copy() }
}

@Parcelize
data class CommentViewData(
    val id: Long,
    val parentId: Long,
    val username: String,
    val avatar: String,
    val content: String,
    val time: String,
    val replies: List<CommentViewData>? = null
) : Parcelable {

    object DiffItemCallback : DiffUtil.ItemCallback<CommentViewData>() {
        override fun areItemsTheSame(
            oldItem: CommentViewData,
            newItem: CommentViewData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CommentViewData,
            newItem: CommentViewData
        ): Boolean {
            return false
        }
    }
}