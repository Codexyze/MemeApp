package com.example.domain.Repository


import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getAllMemes(): Flow<Meme?>
}


// :domain module
data class Meme(
    val count: Int,
    val memes: List<MemeX>
)

data class MemeX(
    val author: String,
    val nsfw: Boolean,
    val postLink: String,
    val preview: List<String>,
    val spoiler: Boolean,
    val subreddit: String,
    val title: String,
    val ups: Int,
    val url: String
)


