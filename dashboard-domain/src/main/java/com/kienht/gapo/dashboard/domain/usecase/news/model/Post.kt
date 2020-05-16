package com.kienht.gapo.dashboard.domain.usecase.news.model

/**
 * @author kienht
 * @company OICSoft
 * @since 16/05/2020
 */
data class Post(
    val id: Long,
    val type: Type,
    val username: String,
    val userAvatar: String,
    val time: String,
    val content: String,
    val images: List<String>?,
    val video: String?,
    val likeCount: String,
    val commentCount: String,
    val shareCount: String
){

    enum class Type {

        TEXT {
            override fun value(): String = "TEXT"
        },
        IMAGE {
            override fun value(): String = "IMAGE"
        },
        VIDEO {
            override fun value(): String = "VIDEO"
        };

        abstract fun value(): String

        companion object {
            fun get(value: String) = values().first { it.value().equals(value, true) }
        }
    }
}