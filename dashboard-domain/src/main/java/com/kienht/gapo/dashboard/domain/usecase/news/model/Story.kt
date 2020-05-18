package com.kienht.gapo.dashboard.domain.usecase.news.model

/**
 * @author kienht
 */
data class Story(
    val id: Long,
    val username: String,
    val userAvatar: String,
    val contentUrl: String
)